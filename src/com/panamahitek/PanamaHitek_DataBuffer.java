package com.panamahitek;

import com.panamahitek.events.DataInsertionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.panamahitek.events.DataInsertionListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class PanamaHitek_DataBuffer {

    private final List<List<Object>> mainBuffer;
    private final List<String> variableList;
    private List<Object> classList;
    private int ROW_COUNT = 0;
    private String SHEET_NAME = "Arduino_log";
    private JTable table;
    private JScrollPane scroll;
    private boolean tableFlag = false;

    private boolean listenerFlag = false;
    private boolean timeFlag = false;
    private int timeColumn = 0;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final ArrayList listeners;


    TableModelListener tableModelListener = new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent tme) {

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                try {
                    Thread.sleep(10);
                    table.repaint();
                    table.getTableHeader().repaint();
                    table.scrollRectToVisible(table.getCellRect(table.getRowCount(), 0, true));
                    table.repaint();
                    table.getTableHeader().repaint();
                    executor.shutdown();
                    executor.awaitTermination(100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanamaHitek_DataBuffer.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    };

    public PanamaHitek_DataBuffer() {
        mainBuffer = new ArrayList<>();
        variableList = new ArrayList<>();
        classList = new ArrayList<>();
        listeners = new ArrayList();
    }

    public void addColumn(int index, String variableName, Object dataType) {
        variableList.add(index, variableName);
        classList.add(dataType);
        List<Object> list = new ArrayList<>();
        mainBuffer.add(list);
    }

    public void addTimeColumn(int index, String variableName) {
        variableList.add(index, variableName);
        classList.add(new Date());
        List<Object> list = new ArrayList<>();
        this.timeColumn = index;
        this.timeFlag = true;
        mainBuffer.add(list);
    }

    public void addDateFormat(SimpleDateFormat format) {
        this.dateFormat = format;
    }

    public void printRow() {

        if (timeFlag) {
            mainBuffer.get(timeColumn).add(ROW_COUNT, dateFormat.format(new Date()));
        }
        ROW_COUNT++;
        for (int i = 0; i < mainBuffer.size(); i++) {
            if (mainBuffer.get(i).size() != ROW_COUNT) {
                while (mainBuffer.get(i).size() != ROW_COUNT) {
                    Object columnValue = classList.get(i);
                    if ((columnValue instanceof String) || (columnValue.equals(String.class))) {
                        mainBuffer.get(i).add("");
                    } else if ((columnValue instanceof Boolean) || (columnValue.equals(Boolean.class))) {
                        mainBuffer.get(i).add(null);
                    } else if ((columnValue instanceof Date) || (columnValue.equals(Date.class))) {
                        mainBuffer.get(i).add(dateFormat.format(new Date()));
                    } else if ((columnValue instanceof Integer) || (columnValue.equals(Integer.class))) {
                        mainBuffer.get(i).add(0);
                    } else if ((columnValue instanceof Long) || (columnValue.equals(Long.class))) {
                        mainBuffer.get(i).add(0);
                    } else if ((columnValue instanceof Float) || (columnValue.equals(Float.class))) {
                        mainBuffer.get(i).add(0);
                    } else if ((columnValue instanceof Double) || (columnValue.equals(Double.class))) {
                        mainBuffer.get(i).add(0);
                    }
                }
            }
        }

        if (tableFlag) {
            Object[] row = new Object[variableList.size()];
            for (int i = 0; i < variableList.size(); i++) {
                row[i] = mainBuffer.get(i).get(ROW_COUNT - 1);
            }
            ((DefaultTableModel) table.getModel()).addRow(row);
        }

        if (listenerFlag) {
            triggerDataInsertionEvent();
        }

    }

    public void addValue(int column, Object value) throws Exception {
        if (column > variableList.size()) {
            throw new Exception("The parameter 'column' can not be greater than"
                    + "number of declared columns");
        }

        mainBuffer.get(column).add(ROW_COUNT, value);
    }

    public int getRowCount() {
        return ROW_COUNT;
    }

    public int getColumnCount() {
        return variableList.size();
    }

    public void setSheetName(String sheetName) {
        this.SHEET_NAME = sheetName;
    }

    public void insertToPanel(JPanel panel) {
        buildTable();
        scroll = new javax.swing.JScrollPane();
        scroll.setViewportView(table);
        scroll.setVisible(true);
        scroll.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        tableFlag = true;
        panel.add(scroll);

    }

    public JTable getTable() {
        buildTable();
        return this.table;
    }

    public JScrollPane getScrollPane() {
        buildTable();
        scroll = new javax.swing.JScrollPane();
        scroll.setViewportView(table);
        scroll.setVisible(true);
        return this.scroll;
    }

    private void buildTable() {
        if (!tableFlag) {
            table = new JTable();

            String[] headerTitles = new String[variableList.size()];
            Object[][] tableContent = new Object[mainBuffer.get(0).size()][variableList.size()];

            for (int i = 0; i < variableList.size(); i++) {
                headerTitles[i] = variableList.get(i);
                for (int j = 0; j < mainBuffer.get(i).size(); j++) {
                    tableContent[j][i] = mainBuffer.get(i).get(j);
                }
            }
            table.setModel(new DefaultTableModel(tableContent, headerTitles));
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(0);
            table.getTableHeader().setReorderingAllowed(false);
            ((DefaultTableModel) table.getModel()).addTableModelListener(tableModelListener);
        }
    }

    public void addEventListener(DataInsertionListener listener) {
        listeners.add(listener);
        listenerFlag = true;
    }

    public void removeEventListener() {
        listeners.remove(listeners.size() - 1);
        listenerFlag = false;
    }

    private void triggerDataInsertionEvent() {
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            DataInsertionListener listener = (DataInsertionListener) li.next();
            DataInsertionEvent readerEvObj = new DataInsertionEvent(this, this);
            (listener).onDataInsertion(readerEvObj);
        }
    }

    public List<Object> getClassList() {
        return classList;
    }

    public List<String> getVariableList() {
        return variableList;
    }

    public List<List<Object>> getMainBuffer() {
        return mainBuffer;
    }

    public int getTimeColumn() {
        return timeColumn;
    }

}
