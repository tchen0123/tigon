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

package co.cask.tigon.data.transaction.queue;

/**
 *
 */
public interface QueueMetrics {

  void emitEnqueue(int count);

  void emitEnqueueBytes(int bytes);

  static final QueueMetrics NOOP_QUEUE_METRICS = new QueueMetrics() {
    @Override
    public void emitEnqueue(int count) {
      // no-op
    }

    @Override
    public void emitEnqueueBytes(int bytes) {
      // no-op
    }
  };
}
