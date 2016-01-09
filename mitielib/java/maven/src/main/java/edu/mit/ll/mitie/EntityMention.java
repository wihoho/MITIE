/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class EntityMention {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected EntityMention(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EntityMention obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_EntityMention(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public EntityMention() {
    this(globalJNI.new_EntityMention__SWIG_0(), true);
  }

  public EntityMention(int start_, int end_) {
    this(globalJNI.new_EntityMention__SWIG_1(start_, end_), true);
  }

  public EntityMention(int start_, int end_, int tag_, double score_) {
    this(globalJNI.new_EntityMention__SWIG_2(start_, end_, tag_, score_), true);
  }

  public void setStart(int value) {
    globalJNI.EntityMention_start_set(swigCPtr, this, value);
  }

  public int getStart() {
    return globalJNI.EntityMention_start_get(swigCPtr, this);
  }

  public void setEnd(int value) {
    globalJNI.EntityMention_end_set(swigCPtr, this, value);
  }

  public int getEnd() {
    return globalJNI.EntityMention_end_get(swigCPtr, this);
  }

  public void setTag(int value) {
    globalJNI.EntityMention_tag_set(swigCPtr, this, value);
  }

  public int getTag() {
    return globalJNI.EntityMention_tag_get(swigCPtr, this);
  }

  public void setScore(double value) {
    globalJNI.EntityMention_score_set(swigCPtr, this, value);
  }

  public double getScore() {
    return globalJNI.EntityMention_score_get(swigCPtr, this);
  }

}
