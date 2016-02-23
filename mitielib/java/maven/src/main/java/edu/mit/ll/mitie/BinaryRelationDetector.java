/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class BinaryRelationDetector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected BinaryRelationDetector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(BinaryRelationDetector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_BinaryRelationDetector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public BinaryRelationDetector(String filename) {
    this(globalJNI.new_BinaryRelationDetector(filename), true);
  }

  public void saveToDisk(String filename) {
    globalJNI.BinaryRelationDetector_saveToDisk(swigCPtr, this, filename);
  }

  public String getNameString() {
    return globalJNI.BinaryRelationDetector_getNameString(swigCPtr, this);
  }

  public double classify(BinaryRelation rel) {
    return globalJNI.BinaryRelationDetector_classify(swigCPtr, this, BinaryRelation.getCPtr(rel), rel);
  }

}
