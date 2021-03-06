/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.giraph.debugger.examples.integrity;

import org.apache.giraph.debugger.DebugConfig;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;

/**
 * Debug configuration file for ConnectedComponents, that is configured to check
 * the integrity of the vertex values: The current check is that the vertex
 * value is less than or equal to the id of the vertex.
 */
public class ConnectedComponentsVValueIntegrityDebugConfig extends DebugConfig<
  LongWritable, LongWritable, NullWritable, LongWritable, LongWritable> {

  @Override
  public boolean shouldCatchExceptions() {
    return false;
  }

  @Override
  public boolean shouldDebugVertex(
    Vertex<LongWritable, LongWritable, NullWritable> vertex, long superstepNo) {
    return false;
  };

  @Override
  public boolean shouldCheckVertexValueIntegrity() {
    return true;
  }

  @Override
  public boolean isVertexValueCorrect(LongWritable vertexId, LongWritable
    value) {
    return value.get() <= vertexId.get();
  }
}
