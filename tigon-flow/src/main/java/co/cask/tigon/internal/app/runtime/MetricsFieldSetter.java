/*
 * Copyright © 2014 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.tigon.internal.app.runtime;

import co.cask.tigon.api.metrics.Metrics;
import co.cask.tigon.internal.lang.FieldVisitor;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.Field;

/**
 * A {@link FieldVisitor} that set Metrics fields.
 */
public final class MetricsFieldSetter extends FieldVisitor {

  private final Metrics metrics;

  public MetricsFieldSetter(Metrics metrics) {
    this.metrics = metrics;
  }

  @Override
  public void visit(Object instance, TypeToken<?> inspectType, TypeToken<?> declareType, Field field) throws Exception {
    if (Metrics.class.equals(field.getType())) {
      field.set(instance, metrics);
    }
  }
}
