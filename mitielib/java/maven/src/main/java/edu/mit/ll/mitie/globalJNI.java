/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

import java.io.IOException;

public class globalJNI {

  static {
    try {
      String osName = System.getProperty("os.name");
      switch (osName) {
        case "Linux":
          NativeUtils.loadLibraryFromJar("/natives/libjavamitie.so");
          break;
        case "Windows 7":
          NativeUtils.loadLibraryFromJar("/natives/javamitie.dll");
          NativeUtils.loadLibraryFromJar("/natives/msvcp140.dll");
          NativeUtils.loadLibraryFromJar("/natives/vcruntime140.dll");
          break;
      }
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. \n" + e);
      System.exit(1);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
    
  public final static native long new_StringVector__SWIG_0();
  public final static native long new_StringVector__SWIG_1(long jarg1);
  public final static native long StringVector_size(long jarg1, StringVector jarg1_);
  public final static native long StringVector_capacity(long jarg1, StringVector jarg1_);
  public final static native void StringVector_reserve(long jarg1, StringVector jarg1_, long jarg2);
  public final static native boolean StringVector_isEmpty(long jarg1, StringVector jarg1_);
  public final static native void StringVector_clear(long jarg1, StringVector jarg1_);
  public final static native void StringVector_add(long jarg1, StringVector jarg1_, String jarg2);
  public final static native String StringVector_get(long jarg1, StringVector jarg1_, int jarg2);
  public final static native void StringVector_set(long jarg1, StringVector jarg1_, int jarg2, String jarg3);
  public final static native void delete_StringVector(long jarg1);
  public final static native long new_TokenIndexVector__SWIG_0();
  public final static native long new_TokenIndexVector__SWIG_1(long jarg1);
  public final static native long TokenIndexVector_size(long jarg1, TokenIndexVector jarg1_);
  public final static native long TokenIndexVector_capacity(long jarg1, TokenIndexVector jarg1_);
  public final static native void TokenIndexVector_reserve(long jarg1, TokenIndexVector jarg1_, long jarg2);
  public final static native boolean TokenIndexVector_isEmpty(long jarg1, TokenIndexVector jarg1_);
  public final static native void TokenIndexVector_clear(long jarg1, TokenIndexVector jarg1_);
  public final static native void TokenIndexVector_add(long jarg1, TokenIndexVector jarg1_, long jarg2, TokenIndexPair jarg2_);
  public final static native long TokenIndexVector_get(long jarg1, TokenIndexVector jarg1_, int jarg2);
  public final static native void TokenIndexVector_set(long jarg1, TokenIndexVector jarg1_, int jarg2, long jarg3, TokenIndexPair jarg3_);
  public final static native void delete_TokenIndexVector(long jarg1);
  public final static native long new_EntityMentionVector__SWIG_0();
  public final static native long new_EntityMentionVector__SWIG_1(long jarg1);
  public final static native long EntityMentionVector_size(long jarg1, EntityMentionVector jarg1_);
  public final static native long EntityMentionVector_capacity(long jarg1, EntityMentionVector jarg1_);
  public final static native void EntityMentionVector_reserve(long jarg1, EntityMentionVector jarg1_, long jarg2);
  public final static native boolean EntityMentionVector_isEmpty(long jarg1, EntityMentionVector jarg1_);
  public final static native void EntityMentionVector_clear(long jarg1, EntityMentionVector jarg1_);
  public final static native void EntityMentionVector_add(long jarg1, EntityMentionVector jarg1_, long jarg2, EntityMention jarg2_);
  public final static native long EntityMentionVector_get(long jarg1, EntityMentionVector jarg1_, int jarg2);
  public final static native void EntityMentionVector_set(long jarg1, EntityMentionVector jarg1_, int jarg2, long jarg3, EntityMention jarg3_);
  public final static native void delete_EntityMentionVector(long jarg1);
  public final static native String loadEntireFile(String jarg1);
  public final static native long tokenize(String jarg1);
  public final static native void TokenIndexPair_index_set(long jarg1, TokenIndexPair jarg1_, long jarg2);
  public final static native long TokenIndexPair_index_get(long jarg1, TokenIndexPair jarg1_);
  public final static native void TokenIndexPair_token_set(long jarg1, TokenIndexPair jarg1_, String jarg2);
  public final static native String TokenIndexPair_token_get(long jarg1, TokenIndexPair jarg1_);
  public final static native long new_TokenIndexPair();
  public final static native void delete_TokenIndexPair(long jarg1);
  public final static native long tokenizeWithOffsets(String jarg1);
  public final static native long new_EntityMention__SWIG_0();
  public final static native long new_EntityMention__SWIG_1(int jarg1, int jarg2);
  public final static native long new_EntityMention__SWIG_2(int jarg1, int jarg2, int jarg3, double jarg4);
  public final static native void EntityMention_start_set(long jarg1, EntityMention jarg1_, int jarg2);
  public final static native int EntityMention_start_get(long jarg1, EntityMention jarg1_);
  public final static native void EntityMention_end_set(long jarg1, EntityMention jarg1_, int jarg2);
  public final static native int EntityMention_end_get(long jarg1, EntityMention jarg1_);
  public final static native void EntityMention_tag_set(long jarg1, EntityMention jarg1_, int jarg2);
  public final static native int EntityMention_tag_get(long jarg1, EntityMention jarg1_);
  public final static native void EntityMention_score_set(long jarg1, EntityMention jarg1_, double jarg2);
  public final static native double EntityMention_score_get(long jarg1, EntityMention jarg1_);
  public final static native void delete_EntityMention(long jarg1);
  public final static native void BinaryRelation_item_set(long jarg1, BinaryRelation jarg1_, long jarg2);
  public final static native long BinaryRelation_item_get(long jarg1, BinaryRelation jarg1_);
  public final static native long new_BinaryRelation();
  public final static native void delete_BinaryRelation(long jarg1);
  public final static native long new_TotalWordFeatureExtractor(String jarg1);
  public final static native void delete_TotalWordFeatureExtractor(long jarg1);
  public final static native long new_MicroNER(String jarg1);
  public final static native long MicroNER_getPossibleNerTags(long jarg1, MicroNER jarg1_);
  public final static native long MicroNER_extractEntities__SWIG_0(long jarg1, MicroNER jarg1_, long jarg2, TotalWordFeatureExtractor jarg2_, long jarg3, StringVector jarg3_);
  public final static native long MicroNER_extractEntities__SWIG_1(long jarg1, MicroNER jarg1_, long jarg2, TotalWordFeatureExtractor jarg2_, long jarg3, TokenIndexVector jarg3_);
  public final static native void delete_MicroNER(long jarg1);
  public final static native long new_NamedEntityExtractor__SWIG_0(String jarg1);
  public final static native long new_NamedEntityExtractor__SWIG_1(String jarg1, String jarg2);
  public final static native long new_NamedEntityExtractor__SWIG_2(String jarg1, long jarg2, TotalWordFeatureExtractor jarg2_);
  public final static native long NamedEntityExtractor_getPossibleNerTags(long jarg1, NamedEntityExtractor jarg1_);
  public final static native void NamedEntityExtractor_saveToDisk(long jarg1, NamedEntityExtractor jarg1_, String jarg2);
  public final static native long NamedEntityExtractor_extractEntities__SWIG_0(long jarg1, NamedEntityExtractor jarg1_, long jarg2, StringVector jarg2_);
  public final static native long NamedEntityExtractor_extractEntities__SWIG_1(long jarg1, NamedEntityExtractor jarg1_, long jarg2, TokenIndexVector jarg2_);
  public final static native long NamedEntityExtractor_extractBinaryRelation(long jarg1, NamedEntityExtractor jarg1_, long jarg2, StringVector jarg2_, long jarg3, EntityMention jarg3_, long jarg4, EntityMention jarg4_);
  public final static native void delete_NamedEntityExtractor(long jarg1);
  public final static native long new_BinaryRelationDetector(String jarg1);
  public final static native void BinaryRelationDetector_saveToDisk(long jarg1, BinaryRelationDetector jarg1_, String jarg2);
  public final static native String BinaryRelationDetector_getNameString(long jarg1, BinaryRelationDetector jarg1_);
  public final static native double BinaryRelationDetector_classify(long jarg1, BinaryRelationDetector jarg1_, long jarg2, BinaryRelation jarg2_);
  public final static native void delete_BinaryRelationDetector(long jarg1);
  public final static native long new_NerTrainingInstance(long jarg1, StringVector jarg1_);
  public final static native void NerTrainingInstance_addEntity(long jarg1, NerTrainingInstance jarg1_, long jarg2, long jarg3, String jarg4);
  public final static native long NerTrainingInstance_getSize(long jarg1, NerTrainingInstance jarg1_);
  public final static native void delete_NerTrainingInstance(long jarg1);
  public final static native long new_NerMicroTrainingInstance(long jarg1, StringVector jarg1_);
  public final static native void NerMicroTrainingInstance_addEntity(long jarg1, NerMicroTrainingInstance jarg1_, long jarg2, long jarg3, String jarg4);
  public final static native long NerMicroTrainingInstance_getSize(long jarg1, NerMicroTrainingInstance jarg1_);
  public final static native void delete_NerMicroTrainingInstance(long jarg1);
  public final static native long new_MicroTrainer();
  public final static native void MicroTrainer_add(long jarg1, MicroTrainer jarg1_, long jarg2, NerMicroTrainingInstance jarg2_);
  public final static native void MicroTrainer_setThreadNum(long jarg1, MicroTrainer jarg1_, long jarg2);
  public final static native void MicroTrainer_setC(long jarg1, MicroTrainer jarg1_, double jarg2);
  public final static native void MicroTrainer_setLoss(long jarg1, MicroTrainer jarg1_, double jarg2);
  public final static native void MicroTrainer_trainSeparateModels(long jarg1, MicroTrainer jarg1_, long jarg2, TotalWordFeatureExtractor jarg2_, String jarg3);
  public final static native double MicroTrainer_getPrecision(long jarg1, MicroTrainer jarg1_);
  public final static native double MicroTrainer_getRecall(long jarg1, MicroTrainer jarg1_);
  public final static native void delete_MicroTrainer(long jarg1);
  public final static native long new_NerTrainer__SWIG_0(String jarg1);
  public final static native long new_NerTrainer__SWIG_1(long jarg1, TotalWordFeatureExtractor jarg1_);
  public final static native void NerTrainer_add(long jarg1, NerTrainer jarg1_, long jarg2, NerTrainingInstance jarg2_);
  public final static native void NerTrainer_setThreadNum(long jarg1, NerTrainer jarg1_, long jarg2);
  public final static native void NerTrainer_train(long jarg1, NerTrainer jarg1_, String jarg2);
  public final static native void NerTrainer_trainSeparateModels(long jarg1, NerTrainer jarg1_, String jarg2);
  public final static native void delete_NerTrainer(long jarg1);
}
