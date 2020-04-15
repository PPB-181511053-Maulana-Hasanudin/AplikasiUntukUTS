
/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.aplikasiuntukuts.data;

import android.content.ContentValues;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Cheese.TABLE_NAME)
public class Cheese {

    /** The name of the Cheese table. */
    public static final String TABLE_NAME = "cheeses";

    /** The name of the ID column. */
    public static final String COLUMN_ID = BaseColumns._ID;

    /** The name of the name column. */
    public static final String COLUMN_NAME = "name";

    /** The unique ID of the cheese. */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long id;

    /** The name of the cheese. */
    @ColumnInfo(name = COLUMN_NAME)
    public String name;

    /**
     * Create a new {@link Cheese} from the specified {@link ContentValues}.
     *
     * @param values A {@link ContentValues} that at least contain {@link #COLUMN_NAME}.
     * @return A newly created {@link Cheese} instance.
     */
    @NonNull
    public static Cheese fromContentValues(@Nullable ContentValues values) {
        final Cheese cheese = new Cheese();
        if (values != null && values.containsKey(COLUMN_ID)) {
            cheese.id = values.getAsLong(COLUMN_ID);
        }
        if (values != null && values.containsKey(COLUMN_NAME)) {
            cheese.name = values.getAsString(COLUMN_NAME);
        }
        return cheese;
    }

    /** Dummy data. */
    static final String[] CHEESES = {
            "Maul", "Ana", "Hasan", "Udin"
    };

}
