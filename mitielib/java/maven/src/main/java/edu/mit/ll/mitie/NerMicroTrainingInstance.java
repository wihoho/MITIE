/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class NerMicroTrainingInstance {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected NerMicroTrainingInstance(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NerMicroTrainingInstance obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_NerMicroTrainingInstance(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public NerMicroTrainingInstance(StringVector tokens) {
    this(globalJNI.new_NerMicroTrainingInstance(StringVector.getCPtr(tokens), tokens), true);
  }

  public void addEntity(long start, long length, String label) {
    globalJNI.NerMicroTrainingInstance_addEntity(swigCPtr, this, start, length, label);
  }

  public long getSize() {
    return globalJNI.NerMicroTrainingInstance_getSize(swigCPtr, this);
  }

}