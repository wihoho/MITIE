package edu.mit.ll.mitie;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author yichao <jin_y@worksap.co.jp> on 3/2/16.
 */
public class JPNerTrainerTest {

    @Test
    public void testTrainSeparateModels() throws Exception {

        Tokenizer tokenizer = Tokenizer.builder().build();

        String modelPath = trainModel(tokenizer);

        NamedEntityExtractor ner = new NamedEntityExtractor(
                modelPath,
                TotalWordFeatureExtractor.getJapaneseExtractor()
        );

        String test1 = "13:30\n" +
                "[dep]\t仙台 時刻表地図\t[jalan]ホテルグルメ\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線はやぶさ18号・東京行\n" +
                "13番線発\n" +
                "指定席：4,850円\n" +
                "14:38着15:22発\t[train]\t大宮(埼玉県) 時刻表地図\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線はくたか567号・金沢行\n" +
                "10駅\n" +
                "自由席：5,520円10,150円\n" +
                "17:50着18:07発\t[train]\t富山 時刻表地図\n" +
                "[line]\n" +
                "[train]あいの風とやま鉄道・金沢行\n" +
                "1番線発\n" +
                "6駅\n" +
                "560円\n" +
                "18:35\n" +
                "[arr]\t福岡 時刻表地図\t[jalan]ホテルグルメ\n";

        StringVector testStringVector = new StringVector();
        for (Token token : tokenizer.tokenize(test1)) {
            testStringVector.add(token.getSurfaceForm());
        }

        System.out.println("Tags output by this NER model are: ");
        StringVector possibleTags = ner.getPossibleNerTags();
        for (int i = 0; i < possibleTags.size(); ++i)
            System.out.println(possibleTags.get(i));

        EntityMentionVector entities = ner.extractEntities(testStringVector);
        System.out.println("Number of entities found: " + entities.size());

        Map<String, String> mapResult = new HashMap<>();
        for (int i = 0; i < entities.size(); ++i) {
            EntityMention entity = entities.get(i);
            String tag = possibleTags.get(entity.getTag());
            System.out.print(": " + tag + ": ");
            String current = printEntity(testStringVector, entity);
            mapResult.put(tag, current);
        }

        assertEquals("仙台 ", mapResult.get("from"));
        assertEquals("福岡 ", mapResult.get("to"));
    }

    public static String printEntity (StringVector words, EntityMention ent) {
        StringBuffer sb = new StringBuffer();
        for (int j = ent.getStart(); j < ent.getEnd(); j++)
            sb.append(words.get(j) + " ");
        sb.append("");
        System.out.println(sb);
        return sb.toString();
    }

    public static NerTrainingInstance dataPrepare(Tokenizer tokenizer, String input) {
        StringVector stringVector = new StringVector();
        int index = 0;
        for (Token token : tokenizer.tokenize(input)) {
            stringVector.add(token.getSurfaceForm());
//            System.out.println(index++ + ": " + token.getSurfaceForm());
        }
        return new NerTrainingInstance(stringVector);
    }

    public static String trainModel(Tokenizer tokenizer) throws IOException {

        String sample1 = "17:10\n" +
                "[dep]\t東京 時刻表出口地図\t[jalan]ホテルグルメ\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線のぞみ53号・博多行\n" +
                "16番線発 / 21番線着\n" +
                "5駅\n" +
                "自由席：4,870円\n" +
                "19:40着19:51発\t[train]\t新大阪 時刻表地図\n" +
                "[line]\n" +
                "[train]ＪＲ京都線・新三田行\n" +
                "15番線発 / 6番線着\n" +
                "8,750円\n" +
                "19:55\n" +
                "[arr]\t大阪 時刻表地図\t[jalan]ホテルグルメ";
        String sample2 = "17:10\n" +
                "[dep]\t東京 時刻表出口地図\t[jalan]ホテルグルメ\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線のぞみ53号・博多行\n" +
                "16番線発 / 21番線着\n" +
                "5駅\n" +
                "自由席：4,870円8,750円\n" +
                "19:40着19:50発\t[train]\t新大阪 時刻表地図\n" +
                "[line]\n" +
                "[train]大阪市営御堂筋線・なかもず行\n" +
                "1番線発 / 1番線着\n" +
                "3駅\n" +
                "240円\n" +
                "19:56着19:58発\t[train]\t梅田(大阪市営) 時刻表出口地図\n" +
                "[line]\n" +
                "[walk]徒歩\n" +
                "20:03\n" +
                "[arr]\t大阪 時刻表地図\t[jalan]ホテルグルメ\n";
        String sample3 = "18:53\n" +
                "[dep]\t京都 時刻表出口地図\t[jalan]ホテルグルメ\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線のぞみ48号・東京行\n" +
                "12番線発 / 14番線着\n" +
                "自由席：2,480円2,590円\n" +
                "19:30\n" +
                "[arr]\t名古屋 時刻表出口地図\t";
        String sample4 = "19:30\n" +
                "[dep]\t仙台 時刻表地図\t[jalan]ホテルグルメ\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線はやぶさ32号・東京行\n" +
                "13番線発 / 21番線着\n" +
                "3駅\n" +
                "指定席：5,060円5,940円\n" +
                "21:04\n" +
                "[arr]\t東京 時刻表出口地図\t[jalan]ホテルグルメ\n";
        String sample5 = "11:24\n" +
                "[dep]\t奈良 時刻表地図\t[jalan]ホテルグルメ\n" +
                "[line]\n" +
                "[train]ＪＲみやこ路快速・京都行\n" +
                "4番線発(乗車位置：前[4両編成]・前[6両編成]) / 8番線着\n" +
                "7駅\n" +
                "12:11着12:36発\t[train]\t京都 時刻表出口地図\n" +
                "[line]\n" +
                "[train]ＪＲ新幹線のぞみ126号・東京行\n" +
                "11番線発 / 1・2番線着\n" +
                "2駅\n" +
                "自由席：4,540円\n" +
                "14:34着14:39発\t[train]\t新横浜 時刻表出口地図\n" +
                "[line]\n" +
                "[train]ＪＲ横浜線・桜木町行\n" +
                "5番線発 / 3番線着\n" +
                "4駅\n" +
                "8,420円\n" +
                "14:52\n" +
                "[arr]\t横浜 時刻表出口地図\t";


        NerTrainingInstance nerTrainingInstance1 = dataPrepare(tokenizer, sample1);
        nerTrainingInstance1.addEntity(8, 1, "from");
        nerTrainingInstance1.addEntity(112, 1, "to");

        NerTrainingInstance nerTrainingInstance2 = dataPrepare(tokenizer, sample2);
        nerTrainingInstance2.addEntity(8, 1, "from");
        nerTrainingInstance2.addEntity(155, 1, "to");

        NerTrainingInstance nerTrainingInstance3 = dataPrepare(tokenizer, sample3);
        nerTrainingInstance3.addEntity(8, 1, "from");
        nerTrainingInstance3.addEntity(67, 1, "to");

        NerTrainingInstance nerTrainingInstance4 = dataPrepare(tokenizer, sample4);
        nerTrainingInstance4.addEntity(8, 1, "from");
        nerTrainingInstance4.addEntity(71, 1, "to");

        NerTrainingInstance nerTrainingInstance5 = dataPrepare(tokenizer, sample5);
        nerTrainingInstance5.addEntity(8, 1, "from");
        nerTrainingInstance5.addEntity(184, 1, "to");

        NerTrainer nerTrainer = new NerTrainer(TotalWordFeatureExtractor.getJapaneseExtractor());
        nerTrainer.add(nerTrainingInstance1);
        nerTrainer.add(nerTrainingInstance2);
        nerTrainer.add(nerTrainingInstance3);
        nerTrainer.add(nerTrainingInstance4);
        nerTrainer.add(nerTrainingInstance5);

        // The trainer can take advantage of a multi-core CPU.  So set the number of threads
        // equal to the number of processing cores for maximum training speed.
        nerTrainer.setThreadNum(4);

        // This function does the work of training.  Note that it can take a long time to run
        // when using larger training datasets.  So be patient.  When it finishes it will
        // save the resulting pure model
        File file = File.createTempFile( "train", "model.dat");
        file.deleteOnExit();

        nerTrainer.trainSeparateModels(file.getAbsolutePath());
        return file.getAbsolutePath();
    }
}