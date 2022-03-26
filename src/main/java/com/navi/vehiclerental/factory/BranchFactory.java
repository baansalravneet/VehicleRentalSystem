package com.navi.vehiclerental.factory;

import com.navi.vehiclerental.models.Branch;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Creates Branch objects
 */
public class BranchFactory {

  public Branch createBranch(String branchId, String... vehicleTypes) {
    return new Branch(branchId, Arrays.stream(vehicleTypes).collect(Collectors.toSet()));
  }

}
