/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package edu.mit.ll.mitie;

public class global {
  public static String loadEntireFile(String filename) {
    return globalJNI.loadEntireFile(filename);
  }

  public static StringVector tokenize(String str) {
    return new StringVector(globalJNI.tokenize(str), true);
  }

  public static TokenIndexVector tokenizeWithOffsets(String str) {
    return new TokenIndexVector(globalJNI.tokenizeWithOffsets(str), true);
  }

}
