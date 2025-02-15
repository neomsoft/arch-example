package arch.example.app.data.preferences.savers

import arch.example.app.core.entities.theme.ThemeMode
import io.github.neomsoft.storage.value.datastore.delegate.StorageValueSaver
import io.github.neomsoft.storage.value.datastore.delegate.internal.StorageValueReader
import io.github.neomsoft.storage.value.datastore.delegate.internal.StorageValueWriter

internal class ThemeModeSaver : StorageValueSaver<ThemeMode> {

    override fun save(writer: StorageValueWriter, value: ThemeMode) {
        writer.string(value = value.name)
    }

    override fun restore(reader: StorageValueReader): ThemeMode {
        return try {
            ThemeMode.valueOf(reader.string()!!)
        } catch (e: Exception) {
            ThemeMode.SystemDynamic
        }
    }
}