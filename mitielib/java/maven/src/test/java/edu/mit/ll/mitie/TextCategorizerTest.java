package edu.mit.ll.mitie;

import java.io.File;

import org.junit.Test;

/**
 * @Author yichao <jin_y@worksap.co.jp> on 13/06/2016.
 */
public class TextCategorizerTest {

    @Test
    public void testTextCategorizer() throws Exception {
        StringVector sentence = new StringVector();
        sentence.add("I");
        sentence.add("am");
        sentence.add("so");
        sentence.add("happy");
        sentence.add("and");
        sentence.add("exciting");
        sentence.add("to");
        sentence.add("make");
        sentence.add("this");

        StringVector sentence2 = new StringVector();
        sentence2.add("What");
        sentence2.add("a");
        sentence2.add("black");
        sentence2.add("and");
        sentence2.add("bad");
        sentence2.add("day");

        File file = File.createTempFile( "train", "model.dat");
        file.deleteOnExit();

        TextCategorizerTrainer trainer = new TextCategorizerTrainer();

        // Don't forget to add the training data.  Here we have only two examples, but for real
        // uses you need to have thousands.
        trainer.add(sentence, "positive");
        trainer.add(sentence2, "negative");

        // The trainer can take advantage of a multi-core CPU.  So set the number of threads
        // equal to the number of processing cores for maximum training speed.
        trainer.setThreadNum(4);
        trainer.setEnableTuningClassifier(false);
        // This function does the work of training.  Note that it can take a long time to run
        // when using larger training datasets.  So be patient.
        trainer.trainSeparateModels(TotalWordFeatureExtractor.getEnglishExtractor(), file.getAbsolutePath());

        // restore the model using the pure model and extractor
        TextCategorizer categorizer = new TextCategorizer( file.getAbsolutePath() );

        // Finally, lets test out our new model on an example sentence
        StringVector testSentence = new StringVector();
        testSentence.add("It");
        testSentence.add("is");
        testSentence.add("really");
        testSentence.add("exciting");

        System.out.println("Tags output by this text categorizer model are: ");
        StringVector possibleTags = categorizer.getPossibleNerTags();
        for (int i = 0; i < possibleTags.size(); ++i)
            System.out.println(possibleTags.get(i));

        // Now ask MITIE to detect the type of the text we just loaded.
        SDPair result = categorizer.categorizeDoc(testSentence, TotalWordFeatureExtractor.getEnglishExtractor());
        System.out.println("The type of this text is: " + result.getFirst() + ", with confidence score as " + result.getSecond());
    }
}
