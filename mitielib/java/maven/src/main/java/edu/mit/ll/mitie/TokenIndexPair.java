/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class TokenIndexPair {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected TokenIndexPair(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(TokenIndexPair obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_TokenIndexPair(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIndex(long value) {
    globalJNI.TokenIndexPair_index_set(swigCPtr, this, value);
  }

  public long getIndex() {
    return globalJNI.TokenIndexPair_index_get(swigCPtr, this);
  }

  public void setToken(String value) {
    globalJNI.TokenIndexPair_token_set(swigCPtr, this, value);
  }

  public String getToken() {
    return globalJNI.TokenIndexPair_token_get(swigCPtr, this);
  }

  public TokenIndexPair() {
    this(globalJNI.new_TokenIndexPair(), true);
  }

}
