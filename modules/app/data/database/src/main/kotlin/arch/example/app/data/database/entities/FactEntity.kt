package arch.example.app.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import arch.example.app.data.database.entities.FactEntity.Table.TABLE_NAME

@Entity(tableName = TABLE_NAME)
internal data class FactEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Table.Columns.ID)
    val id: Int = 0,

    @ColumnInfo(name = Table.Columns.FACT)
    val fact: String,
) {

    object Table {
        const val TABLE_NAME = "facts"

        object Columns {
            const val ID = "id"
            const val FACT = "fact"
        }
    }
}