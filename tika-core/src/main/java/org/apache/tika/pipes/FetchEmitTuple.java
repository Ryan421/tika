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
package org.apache.tika.pipes;

import java.util.Objects;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.fetcher.FetchKey;

public class FetchEmitTuple {

    public static final ON_PARSE_EXCEPTION DEFAULT_ON_PARSE_EXCEPTION = ON_PARSE_EXCEPTION.EMIT;

    public enum ON_PARSE_EXCEPTION {
        SKIP, EMIT
    }

    private final FetchKey fetchKey;
    private EmitKey emitKey;
    private final Metadata metadata;
    private final ON_PARSE_EXCEPTION onParseException;
    private HandlerConfig handlerConfig;

    public FetchEmitTuple(FetchKey fetchKey, EmitKey emitKey, Metadata metadata) {
        this(fetchKey, emitKey, metadata, HandlerConfig.DEFAULT_HANDLER_CONFIG,
                DEFAULT_ON_PARSE_EXCEPTION);
    }

    public FetchEmitTuple(FetchKey fetchKey, EmitKey emitKey, Metadata metadata,
                          HandlerConfig handlerConfig, ON_PARSE_EXCEPTION onParseException) {
        this.fetchKey = fetchKey;
        this.emitKey = emitKey;
        this.metadata = metadata;
        this.handlerConfig = handlerConfig;
        this.onParseException = onParseException;
    }

    public FetchKey getFetchKey() {
        return fetchKey;
    }

    public EmitKey getEmitKey() {
        return emitKey;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public ON_PARSE_EXCEPTION getOnParseException() {
        return onParseException;
    }

    public void setEmitKey(EmitKey emitKey) {
        this.emitKey = emitKey;
    }

    public void setHandlerConfig(HandlerConfig handlerConfig) {
        this.handlerConfig = handlerConfig;
    }

    public HandlerConfig getHandlerConfig() {
        return handlerConfig == null ? HandlerConfig.DEFAULT_HANDLER_CONFIG : handlerConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FetchEmitTuple that = (FetchEmitTuple) o;
        return Objects.equals(fetchKey, that.fetchKey) && Objects.equals(emitKey, that.emitKey) &&
                Objects.equals(metadata, that.metadata) &&
                onParseException == that.onParseException &&
                Objects.equals(handlerConfig, that.handlerConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fetchKey, emitKey, metadata, onParseException, handlerConfig);
    }

    @Override
    public String toString() {
        return "FetchEmitTuple{" + "fetchKey=" + fetchKey + ", emitKey=" + emitKey + ", metadata=" +
                metadata + ", onParseException=" + onParseException + ", handlerConfig=" +
                handlerConfig + '}';
    }
}
