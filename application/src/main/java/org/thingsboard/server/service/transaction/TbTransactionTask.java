/**
 * Copyright © 2016-2020 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.service.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.thingsboard.server.common.msg.TbMsg;

import java.util.function.Consumer;

@Data
@AllArgsConstructor
public final class TbTransactionTask {

    private final TbMsg msg;
    private final Consumer<TbMsg> onStart;
    private final Consumer<TbMsg> onEnd;
    private final Consumer<Throwable> onFailure;
    private final long expirationTime;

    private boolean isCompleted;

    public TbTransactionTask(TbMsg msg, Consumer<TbMsg> onStart, Consumer<TbMsg> onEnd, Consumer<Throwable> onFailure, long expirationTime) {
        this.msg = msg;
        this.onStart = onStart;
        this.onEnd = onEnd;
        this.onFailure = onFailure;
        this.expirationTime = expirationTime;
        this.isCompleted = false;
    }
}
