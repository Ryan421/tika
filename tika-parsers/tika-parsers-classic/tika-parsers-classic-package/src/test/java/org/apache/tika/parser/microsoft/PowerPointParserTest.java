/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.parser.microsoft;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import org.apache.tika.TikaTest;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;

public class PowerPointParserTest extends TikaTest {
    @Test
    public void testEmbeddedPDF() throws Exception {
        List<Metadata> metadataList = getRecursiveMetadata("testPPT_EmbeddedPDF.ppt");
        assertContains("Apache Tika project",
                metadataList.get(1).get(TikaCoreProperties.TIKA_CONTENT));
        assertEquals("3.pdf", metadataList.get(1).get(TikaCoreProperties.RESOURCE_NAME_KEY));
        assertContains("Hello World", metadataList.get(2).get(TikaCoreProperties.TIKA_CONTENT));
        assertEquals("4.pdf", metadataList.get(2).get(TikaCoreProperties.RESOURCE_NAME_KEY));
    }
}
