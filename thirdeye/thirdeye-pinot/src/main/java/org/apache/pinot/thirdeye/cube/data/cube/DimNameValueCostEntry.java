/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pinot.thirdeye.cube.data.cube;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

public class DimNameValueCostEntry implements Comparable<DimNameValueCostEntry>{
  private String dimName;
  private String dimValue;
  private double baselineValue;
  private double currentValue;
  private double changeRatio;
  private double changeDiff;
  private double baselineSize;
  private double currentSize;
  private double sizeFactor;
  private double cost;

  public DimNameValueCostEntry(String dimensionName, String dimensionValue, double baselineValue, double currentValue,
      double changeRatio, double changeDiff, double baselineSize, double currentSize, double sizeFactor, double cost) {
    Preconditions.checkNotNull(dimensionName, "dimension name cannot be null.");
    Preconditions.checkNotNull(dimensionValue, "dimension value cannot be null.");

    this.dimName = dimensionName;
    this.dimValue = dimensionValue;
    this.baselineValue = baselineValue;
    this.currentValue = currentValue;
    this.changeRatio = changeRatio;
    this.changeDiff = changeDiff;
    this.baselineSize = baselineSize;
    this.currentSize = currentSize;
    this.sizeFactor = sizeFactor;
    this.cost = cost;
  }

  public double getSizeFactor() {
    return sizeFactor;
  }

  public void setSizeFactor(double sizeFactor) {
    this.sizeFactor = sizeFactor;
  }

  public String getDimName() {
    return dimName;
  }

  public void setDimName(String dimName) {
    this.dimName = dimName;
  }

  public String getDimValue() {
    return dimValue;
  }

  public void setDimValue(String dimValue) {
    this.dimValue = dimValue;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public double getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(double currentValue) {
    this.currentValue = currentValue;
  }

  public double getBaselineValue() {
    return baselineValue;
  }

  public void setBaselineValue(double baselineValue) {
    this.baselineValue = baselineValue;
  }

  public double getBaselineSize() {
    return baselineSize;
  }

  public void setBaselineSize(double baselineSize) {
    this.baselineSize = baselineSize;
  }

  public double getCurrentSize() {
    return currentSize;
  }

  public void setCurrentSize(double currentSize) {
    this.currentSize = currentSize;
  }

  public double getChangeRatio() {
    return changeRatio;
  }

  public void setChangeRatio(double changeRatio) {
    this.changeRatio = changeRatio;
  }

  public double getChangeDiff() {
    return changeDiff;
  }

  public void setChangeDiff(double changeDiff) {
    this.changeDiff = changeDiff;
  }

  @Override
  public int compareTo(DimNameValueCostEntry that) {
    return Double.compare(this.cost, that.cost);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Entry")
        .add("dim", String.format("%s:%s", dimName, dimValue))
        .add("baseVal", baselineValue)
        .add("curVal", currentValue)
        .add("ratio", String.format("%.4f", changeRatio))
        .add("delta", changeDiff)
        .add("baseSize", baselineSize)
        .add("curSize", currentSize)
        .add("sizeFactor", String.format("%.4f", sizeFactor))
        .add("cost", String.format("%.6f", cost))
        .toString();
  }
}

