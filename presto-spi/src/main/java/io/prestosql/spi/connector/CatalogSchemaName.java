/*
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
package io.prestosql.spi.connector;

import java.util.Objects;

import static io.prestosql.spi.connector.Name.createNonDelimitedName;
import static java.util.Objects.requireNonNull;

public final class CatalogSchemaName
{
    private final Name catalogName;
    private final Name schemaName;

    @Deprecated
    public CatalogSchemaName(String catalogName, String schemaName)
    {
        this(createNonDelimitedName(catalogName), createNonDelimitedName(schemaName));
    }

    public CatalogSchemaName(Name catalogName, Name schemaName)
    {
        this.catalogName = requireNonNull(catalogName, "CatalogName is null");
        this.schemaName = requireNonNull(schemaName, "SchemaName is null");
    }

    public Name getCatalogName()
    {
        return catalogName;
    }

    public Name getSchemaName()
    {
        return schemaName;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        CatalogSchemaName that = (CatalogSchemaName) obj;
        return Objects.equals(catalogName, that.catalogName) &&
                Objects.equals(schemaName, that.schemaName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(catalogName, schemaName);
    }

    @Override
    public String toString()
    {
        return catalogName.getLegacyName() + '.' + schemaName.getLegacyName();
    }
}
