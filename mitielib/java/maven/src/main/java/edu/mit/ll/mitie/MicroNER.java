/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class MicroNER {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MicroNER(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MicroNER obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_MicroNER(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public MicroNER(String pureModelName) {
    this(globalJNI.new_MicroNER(pureModelName), true);
  }

  public StringVector getPossibleNerTags() {
    return new StringVector(globalJNI.MicroNER_getPossibleNerTags(swigCPtr, this), true);
  }

  public EntityMentionVector extractEntities(TotalWordFeatureExtractor extractorObject, StringVector tokens) {
    return new EntityMentionVector(globalJNI.MicroNER_extractEntities__SWIG_0(swigCPtr, this, TotalWordFeatureExtractor.getCPtr(extractorObject), extractorObject, StringVector.getCPtr(tokens), tokens), true);
  }

  public EntityMentionVector extractEntities(TotalWordFeatureExtractor extractorObject, TokenIndexVector tokens) {
    return new EntityMentionVector(globalJNI.MicroNER_extractEntities__SWIG_1(swigCPtr, this, TotalWordFeatureExtractor.getCPtr(extractorObject), extractorObject, TokenIndexVector.getCPtr(tokens), tokens), true);
  }

}
