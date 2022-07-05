/*
 * Copyright 2019 Google LLC
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

package com.example.data.repository.history_novels

import com.example.data.local.daos.LastRequestDao
import com.example.data.local.entities.Request
import com.example.data.repository.lastrequests.GroupLastRequestStore
import javax.inject.Inject

class HistoryNovelShowsLastRequestStore @Inject constructor(
    dao: LastRequestDao
) : GroupLastRequestStore(Request.HISTORY_NOVELS, dao)
