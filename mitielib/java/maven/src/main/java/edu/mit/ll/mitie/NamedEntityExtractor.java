/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class NamedEntityExtractor {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NamedEntityExtractor(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NamedEntityExtractor obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_NamedEntityExtractor(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public NamedEntityExtractor(String filename) {
    this(globalJNI.new_NamedEntityExtractor__SWIG_0(filename), true);
  }

  public NamedEntityExtractor(String pureModelName, String extractorName) {
    this(globalJNI.new_NamedEntityExtractor__SWIG_1(pureModelName, extractorName), true);
  }

  public NamedEntityExtractor(String pureModelName, TotalWordFeatureExtractor extractorObject) {
    this(globalJNI.new_NamedEntityExtractor__SWIG_2(pureModelName, TotalWordFeatureExtractor.getCPtr(extractorObject), extractorObject), true);
  }

  public StringVector getPossibleNerTags() {
    return new StringVector(globalJNI.NamedEntityExtractor_getPossibleNerTags(swigCPtr, this), true);
  }

  public void saveToDisk(String filename) {
    globalJNI.NamedEntityExtractor_saveToDisk(swigCPtr, this, filename);
  }

  public EntityMentionVector extractEntities(StringVector tokens) {
    return new EntityMentionVector(globalJNI.NamedEntityExtractor_extractEntities__SWIG_0(swigCPtr, this, StringVector.getCPtr(tokens), tokens), true);
  }

  public EntityMentionVector extractEntities(TokenIndexVector tokens) {
    return new EntityMentionVector(globalJNI.NamedEntityExtractor_extractEntities__SWIG_1(swigCPtr, this, TokenIndexVector.getCPtr(tokens), tokens), true);
  }

  public BinaryRelation extractBinaryRelation(StringVector tokens, EntityMention arg1, EntityMention arg2) {
    return new BinaryRelation(globalJNI.NamedEntityExtractor_extractBinaryRelation(swigCPtr, this, StringVector.getCPtr(tokens), tokens, EntityMention.getCPtr(arg1), arg1, EntityMention.getCPtr(arg2), arg2), true);
  }

}
