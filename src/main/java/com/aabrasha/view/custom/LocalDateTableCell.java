package com.aabrasha.view.custom;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Abrasha on 05-Jan-16.
 */
public class LocalDateTableCell<S> extends TableCell<S, LocalDate> {

    private DatePicker datePicker;



    public LocalDateTableCell(){
        super();
        datePicker = new DatePicker();
        datePicker.setConverter(new StringConverter<LocalDate>() {

            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");



            @Override
            public String toString(LocalDate object){
                if (object == null)
                    return "";
                return dateTimeFormatter.format(object);
            }



            @Override
            public LocalDate fromString(String string){
                if (string == null || string.trim().isEmpty()){
                    return null;
                }
                return LocalDate.parse(string, dateTimeFormatter);
            }
        });
        datePicker.setOnShowing(e -> {
            final TableView<S> tableView = getTableView();
            tableView.getSelectionModel().select(getTableRow().getIndex());
            tableView.edit(tableView.getSelectionModel().getSelectedIndex(), getTableColumn());
        });
        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue){
                if (isEditing())
                    commitEdit(newValue);
            }
        });
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

    }



    @Override
    protected void updateItem(LocalDate item, boolean empty){
        super.updateItem(item, empty);

        if (item == null || empty){
            setText(null);
            setGraphic(null);
        } else {

            if (!item.equals(LocalDate.MAX))
                datePicker.setValue(item);
            setGraphic(datePicker);
        }

    }


}
