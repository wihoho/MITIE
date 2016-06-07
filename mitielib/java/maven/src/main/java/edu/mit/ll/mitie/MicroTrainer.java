/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class MicroTrainer {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MicroTrainer(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MicroTrainer obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        globalJNI.delete_MicroTrainer(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public MicroTrainer() {
    this(globalJNI.new_MicroTrainer(), true);
  }

  public void add(NerMicroTrainingInstance item) {
    globalJNI.MicroTrainer_add(swigCPtr, this, NerMicroTrainingInstance.getCPtr(item), item);
  }

  public void setThreadNum(long num) {
    globalJNI.MicroTrainer_setThreadNum(swigCPtr, this, num);
  }

  public void setC(double c) {
    globalJNI.MicroTrainer_setC(swigCPtr, this, c);
  }

  public void setLoss(double loss) {
    globalJNI.MicroTrainer_setLoss(swigCPtr, this, loss);
  }

  public void setEnableSegmenter(boolean enabler) {
    globalJNI.MicroTrainer_setEnableSegmenter(swigCPtr, this, enabler);
  }

  public void setEnableTuningClassifier(boolean enabler) {
    globalJNI.MicroTrainer_setEnableTuningClassifier(swigCPtr, this, enabler);
  }

  public void trainSeparateModels(TotalWordFeatureExtractor extractorObject, String filename) {
    globalJNI.MicroTrainer_trainSeparateModels(swigCPtr, this, TotalWordFeatureExtractor.getCPtr(extractorObject), extractorObject, filename);
  }

  public double getPrecision() {
    return globalJNI.MicroTrainer_getPrecision(swigCPtr, this);
  }

  public double getRecall() {
    return globalJNI.MicroTrainer_getRecall(swigCPtr, this);
  }

}
