package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskRealmProxy extends com.example.hieuit.android7_pomodoro.databases.models.Task
    implements RealmObjectProxy, TaskRealmProxyInterface {

    static final class TaskColumnInfo extends ColumnInfo
        implements Cloneable {

        public long nameIndex;
        public long colorIndex;
        public long paymentPerHourIndex;
        public long isDoneIndex;
        public long localIdIndex;

        TaskColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.nameIndex = getValidColumnIndex(path, table, "Task", "name");
            indicesMap.put("name", this.nameIndex);
            this.colorIndex = getValidColumnIndex(path, table, "Task", "color");
            indicesMap.put("color", this.colorIndex);
            this.paymentPerHourIndex = getValidColumnIndex(path, table, "Task", "paymentPerHour");
            indicesMap.put("paymentPerHour", this.paymentPerHourIndex);
            this.isDoneIndex = getValidColumnIndex(path, table, "Task", "isDone");
            indicesMap.put("isDone", this.isDoneIndex);
            this.localIdIndex = getValidColumnIndex(path, table, "Task", "localId");
            indicesMap.put("localId", this.localIdIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final TaskColumnInfo otherInfo = (TaskColumnInfo) other;
            this.nameIndex = otherInfo.nameIndex;
            this.colorIndex = otherInfo.colorIndex;
            this.paymentPerHourIndex = otherInfo.paymentPerHourIndex;
            this.isDoneIndex = otherInfo.isDoneIndex;
            this.localIdIndex = otherInfo.localIdIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final TaskColumnInfo clone() {
            return (TaskColumnInfo) super.clone();
        }

    }
    private TaskColumnInfo columnInfo;
    private ProxyState<com.example.hieuit.android7_pomodoro.databases.models.Task> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("color");
        fieldNames.add("paymentPerHour");
        fieldNames.add("isDone");
        fieldNames.add("localId");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    TaskRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaskColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.hieuit.android7_pomodoro.databases.models.Task>(com.example.hieuit.android7_pomodoro.databases.models.Task.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$color() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.colorIndex);
    }

    public void realmSet$color(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.colorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.colorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.colorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.colorIndex, value);
    }

    @SuppressWarnings("cast")
    public float realmGet$paymentPerHour() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.paymentPerHourIndex);
    }

    public void realmSet$paymentPerHour(float value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.paymentPerHourIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.paymentPerHourIndex, value);
    }

    @SuppressWarnings("cast")
    public boolean realmGet$isDone() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isDoneIndex);
    }

    public void realmSet$isDone(boolean value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isDoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isDoneIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$localId() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.localIdIndex);
    }

    public void realmSet$localId(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'localId' cannot be changed after object was created.");
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Task")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Task");
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("color", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("paymentPerHour", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("isDone", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("localId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Task");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Task")) {
            Table table = sharedRealm.getTable("class_Task");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "color", Table.NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "paymentPerHour", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.BOOLEAN, "isDone", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "localId", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("localId"));
            table.setPrimaryKey("localId");
            return table;
        }
        return sharedRealm.getTable("class_Task");
    }

    public static TaskColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Task")) {
            Table table = sharedRealm.getTable("class_Task");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final TaskColumnInfo columnInfo = new TaskColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'localId' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.localIdIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field localId");
                }
            }

            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("color")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'color' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("color") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'color' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.colorIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'color' is required. Either set @Required to field 'color' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("paymentPerHour")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paymentPerHour' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("paymentPerHour") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'paymentPerHour' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.paymentPerHourIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paymentPerHour' does support null values in the existing Realm file. Use corresponding boxed type for field 'paymentPerHour' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("isDone")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isDone' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("isDone") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isDone' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.isDoneIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isDone' does support null values in the existing Realm file. Use corresponding boxed type for field 'isDone' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("localId")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'localId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("localId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'localId' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.localIdIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'localId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("localId"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'localId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Task' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Task";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.hieuit.android7_pomodoro.databases.models.Task createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.hieuit.android7_pomodoro.databases.models.Task obj = null;
        if (update) {
            Table table = realm.getTable(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("localId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("localId"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.hieuit.android7_pomodoro.databases.models.Task.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TaskRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("localId")) {
                if (json.isNull("localId")) {
                    obj = (io.realm.TaskRealmProxy) realm.createObjectInternal(com.example.hieuit.android7_pomodoro.databases.models.Task.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TaskRealmProxy) realm.createObjectInternal(com.example.hieuit.android7_pomodoro.databases.models.Task.class, json.getString("localId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'localId'.");
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((TaskRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((TaskRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("color")) {
            if (json.isNull("color")) {
                ((TaskRealmProxyInterface) obj).realmSet$color(null);
            } else {
                ((TaskRealmProxyInterface) obj).realmSet$color((String) json.getString("color"));
            }
        }
        if (json.has("paymentPerHour")) {
            if (json.isNull("paymentPerHour")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'paymentPerHour' to null.");
            } else {
                ((TaskRealmProxyInterface) obj).realmSet$paymentPerHour((float) json.getDouble("paymentPerHour"));
            }
        }
        if (json.has("isDone")) {
            if (json.isNull("isDone")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isDone' to null.");
            } else {
                ((TaskRealmProxyInterface) obj).realmSet$isDone((boolean) json.getBoolean("isDone"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.hieuit.android7_pomodoro.databases.models.Task createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.hieuit.android7_pomodoro.databases.models.Task obj = new com.example.hieuit.android7_pomodoro.databases.models.Task();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaskRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((TaskRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("color")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaskRealmProxyInterface) obj).realmSet$color(null);
                } else {
                    ((TaskRealmProxyInterface) obj).realmSet$color((String) reader.nextString());
                }
            } else if (name.equals("paymentPerHour")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'paymentPerHour' to null.");
                } else {
                    ((TaskRealmProxyInterface) obj).realmSet$paymentPerHour((float) reader.nextDouble());
                }
            } else if (name.equals("isDone")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isDone' to null.");
                } else {
                    ((TaskRealmProxyInterface) obj).realmSet$isDone((boolean) reader.nextBoolean());
                }
            } else if (name.equals("localId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((TaskRealmProxyInterface) obj).realmSet$localId(null);
                } else {
                    ((TaskRealmProxyInterface) obj).realmSet$localId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'localId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.hieuit.android7_pomodoro.databases.models.Task copyOrUpdate(Realm realm, com.example.hieuit.android7_pomodoro.databases.models.Task object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.hieuit.android7_pomodoro.databases.models.Task) cachedRealmObject;
        } else {
            com.example.hieuit.android7_pomodoro.databases.models.Task realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((TaskRealmProxyInterface) object).realmGet$localId();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.hieuit.android7_pomodoro.databases.models.Task.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.TaskRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.example.hieuit.android7_pomodoro.databases.models.Task copy(Realm realm, com.example.hieuit.android7_pomodoro.databases.models.Task newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.hieuit.android7_pomodoro.databases.models.Task) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.hieuit.android7_pomodoro.databases.models.Task realmObject = realm.createObjectInternal(com.example.hieuit.android7_pomodoro.databases.models.Task.class, ((TaskRealmProxyInterface) newObject).realmGet$localId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((TaskRealmProxyInterface) realmObject).realmSet$name(((TaskRealmProxyInterface) newObject).realmGet$name());
            ((TaskRealmProxyInterface) realmObject).realmSet$color(((TaskRealmProxyInterface) newObject).realmGet$color());
            ((TaskRealmProxyInterface) realmObject).realmSet$paymentPerHour(((TaskRealmProxyInterface) newObject).realmGet$paymentPerHour());
            ((TaskRealmProxyInterface) realmObject).realmSet$isDone(((TaskRealmProxyInterface) newObject).realmGet$isDone());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.hieuit.android7_pomodoro.databases.models.Task object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.schema.getColumnInfo(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((TaskRealmProxyInterface) object).realmGet$localId();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((TaskRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$color = ((TaskRealmProxyInterface)object).realmGet$color();
        if (realmGet$color != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.colorIndex, rowIndex, realmGet$color, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.paymentPerHourIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$paymentPerHour(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$isDone(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.schema.getColumnInfo(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.hieuit.android7_pomodoro.databases.models.Task object = null;
        while (objects.hasNext()) {
            object = (com.example.hieuit.android7_pomodoro.databases.models.Task) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((TaskRealmProxyInterface) object).realmGet$localId();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((TaskRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$color = ((TaskRealmProxyInterface)object).realmGet$color();
                if (realmGet$color != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.colorIndex, rowIndex, realmGet$color, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.paymentPerHourIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$paymentPerHour(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$isDone(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.hieuit.android7_pomodoro.databases.models.Task object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.schema.getColumnInfo(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((TaskRealmProxyInterface) object).realmGet$localId();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((TaskRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$color = ((TaskRealmProxyInterface)object).realmGet$color();
        if (realmGet$color != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.colorIndex, rowIndex, realmGet$color, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.colorIndex, rowIndex, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.paymentPerHourIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$paymentPerHour(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$isDone(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long tableNativePtr = table.getNativeTablePointer();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.schema.getColumnInfo(com.example.hieuit.android7_pomodoro.databases.models.Task.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.hieuit.android7_pomodoro.databases.models.Task object = null;
        while (objects.hasNext()) {
            object = (com.example.hieuit.android7_pomodoro.databases.models.Task) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((TaskRealmProxyInterface) object).realmGet$localId();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((TaskRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$color = ((TaskRealmProxyInterface)object).realmGet$color();
                if (realmGet$color != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.colorIndex, rowIndex, realmGet$color, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.colorIndex, rowIndex, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.paymentPerHourIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$paymentPerHour(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, ((TaskRealmProxyInterface)object).realmGet$isDone(), false);
            }
        }
    }

    public static com.example.hieuit.android7_pomodoro.databases.models.Task createDetachedCopy(com.example.hieuit.android7_pomodoro.databases.models.Task realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.hieuit.android7_pomodoro.databases.models.Task unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.hieuit.android7_pomodoro.databases.models.Task)cachedObject.object;
            } else {
                unmanagedObject = (com.example.hieuit.android7_pomodoro.databases.models.Task)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.hieuit.android7_pomodoro.databases.models.Task();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((TaskRealmProxyInterface) unmanagedObject).realmSet$name(((TaskRealmProxyInterface) realmObject).realmGet$name());
        ((TaskRealmProxyInterface) unmanagedObject).realmSet$color(((TaskRealmProxyInterface) realmObject).realmGet$color());
        ((TaskRealmProxyInterface) unmanagedObject).realmSet$paymentPerHour(((TaskRealmProxyInterface) realmObject).realmGet$paymentPerHour());
        ((TaskRealmProxyInterface) unmanagedObject).realmSet$isDone(((TaskRealmProxyInterface) realmObject).realmGet$isDone());
        ((TaskRealmProxyInterface) unmanagedObject).realmSet$localId(((TaskRealmProxyInterface) realmObject).realmGet$localId());
        return unmanagedObject;
    }

    static com.example.hieuit.android7_pomodoro.databases.models.Task update(Realm realm, com.example.hieuit.android7_pomodoro.databases.models.Task realmObject, com.example.hieuit.android7_pomodoro.databases.models.Task newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((TaskRealmProxyInterface) realmObject).realmSet$name(((TaskRealmProxyInterface) newObject).realmGet$name());
        ((TaskRealmProxyInterface) realmObject).realmSet$color(((TaskRealmProxyInterface) newObject).realmGet$color());
        ((TaskRealmProxyInterface) realmObject).realmSet$paymentPerHour(((TaskRealmProxyInterface) newObject).realmGet$paymentPerHour());
        ((TaskRealmProxyInterface) realmObject).realmSet$isDone(((TaskRealmProxyInterface) newObject).realmGet$isDone());
        return realmObject;
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskRealmProxy aTask = (TaskRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTask.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTask.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTask.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
