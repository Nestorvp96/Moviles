package com.iteso.sesion9;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.sesion9.beans.Category;


import java.util.ArrayList;

public class CategoryControl {

    public ArrayList<Category> getCategories(DataBaseHandler dh){

        ArrayList<Category> categories = new ArrayList<Category>();
        Category category = new Category();

        String selectQuery = "SELECT " + DataBaseHandler.KEY_CATEGORY_ID + ","
                + DataBaseHandler.KEY_CATEGORY_NAME
                + " FROM "
                + DataBaseHandler.TABLE_CATEGORY;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        try {
            while (cursor.moveToNext()) {
                category.setId(cursor.getInt(0));
                category.setName(cursor.getString(1));
                categories.add(category);
            }


        } catch (Exception e) {}
        finally {
            cursor.close();
            db.close();
        }
        db = null;
        cursor = null;


        return categories;
    }

}
