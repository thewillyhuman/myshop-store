package com.myshop.store.igu;

	import javax.swing.table.*;

	public class ModeloNoEditable extends DefaultTableModel {
		//Usarlo en la ventana principal
		private static final long serialVersionUID = 1L;

		public ModeloNoEditable(Object[] columnNames, int rowCount) {
			super(columnNames, rowCount);
	   }
		@Override
		public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	}

