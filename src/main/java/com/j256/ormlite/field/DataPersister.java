package com.j256.ormlite.field;

import java.lang.reflect.Field;
import java.sql.SQLException;

import com.j256.ormlite.field.types.BaseDataType;

/**
 * Data type that provide Java class to/from database mapping.
 * 
 * <p>
 * If you are defining your own custom persister, then chances are you should extend {@link BaseDataType}. See
 * {@link DatabaseField#persisterClass()}.
 * </p>
 * 
 * @author graywatson
 */
public interface DataPersister extends FieldConverter {

	/**
	 * Return the classes that should be associated with this.
	 */
	public Class<?>[] getAssociatedClasses();

	/**
	 * This makes a configuration object for the data-type or returns null if none. The object can be accessed later via
	 * {@link FieldType#getDataTypeConfigObj()}.
	 */
	public Object makeConfigObject(FieldType fieldType) throws SQLException;

	/**
	 * Convert a {@link Number} object to its primitive object suitable for assigning to an ID field.
	 */
	public Object convertIdNumber(Number number);

	/**
	 * Return true if this type can be auto-generated by the database. Probably only numbers will return true.
	 */
	public boolean isValidGeneratedType();

	/**
	 * Return true if the field is appropriate for this persister.
	 */
	public boolean isValidForField(Field field);

	/**
	 * Return whether this field's default value should be escaped in SQL.
	 */
	public boolean isEscapedDefaultValue();

	/**
	 * Return whether this field is a number.
	 */
	public boolean isEscapedValue();

	/**
	 * Return whether this field is a primitive type or not. This is used to know if we should throw if the field value
	 * is null.
	 */
	public boolean isPrimitive();

	/**
	 * Return true if this data type be compared in SQL statements.
	 */
	public boolean isComparable();

	/**
	 * Return true if this data type can be an id column in a class.
	 */
	public boolean isAppropriateId();

	/**
	 * Must use SelectArg when querying for values of this type.
	 */
	public boolean isSelectArgRequired();

	/**
	 * Return true if this type creates its own generated ids else false to have the database do it.
	 */
	public boolean isSelfGeneratedId();

	/**
	 * Return a generated id if appropriate or null if none.
	 */
	public Object generatedId();

	/**
	 * Return the default width associated with this type or 0 if none.
	 */
	public int getDefaultWidth();
}
