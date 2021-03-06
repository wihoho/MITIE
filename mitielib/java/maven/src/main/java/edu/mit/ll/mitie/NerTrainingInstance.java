/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class NerTrainingInstance {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected NerTrainingInstance(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NerTrainingInstance obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_NerTrainingInstance(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public NerTrainingInstance(StringVector tokens) {
    this(globalJNI.new_NerTrainingInstance(StringVector.getCPtr(tokens), tokens), true);
  }

  public void addEntity(long start, long length, String label) {
    globalJNI.NerTrainingInstance_addEntity(swigCPtr, this, start, length, label);
  }

  public long getSize() {
    return globalJNI.NerTrainingInstance_getSize(swigCPtr, this);
  }

}
