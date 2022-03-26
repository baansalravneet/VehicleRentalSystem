package com.navi.vehiclerental.models;

/**
 * Time slot
 */
public class Slot {

  private final int start;
  private final int end;

  public Slot(int start, int end) {
    // throw an exception for incorrect time slot
    if (start >= end) {
      throw new RuntimeException();
    }
    this.start = start;
    this.end = end;
  }

  // slots are clashing if the sum of lengths of the two slots is less than the time they span.
  public boolean isClashing(Slot s) {
    return Math.max(s.end, this.end) - Math.min(s.start, this.start)
        < this.end - this.start + s.end - s.start;
  }

  public int getTime() {
    return this.end - this.start;
  }

}
