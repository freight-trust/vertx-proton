/*
* Copyright 2016 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package io.vertx.proton.sasl.impl;

import io.vertx.proton.sasl.ProtonSaslMechanism;

public abstract class ProtonSaslMechanismImpl implements ProtonSaslMechanism {

  protected static final byte[] EMPTY = new byte[0];

  private String username;
  private String password;

  @Override
  public int compareTo(ProtonSaslMechanism other) {

    if (getPriority() < other.getPriority()) {
      return -1;
    } else if (getPriority() > other.getPriority()) {
      return 1;
    }

    return 0;
  }

  @Override
  public ProtonSaslMechanism setUsername(String value) {
    this.username = value;
    return this;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public ProtonSaslMechanism setPassword(String value) {
    this.password = value;
    return this;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String toString() {
    return "SASL-" + getName();
  }
}
