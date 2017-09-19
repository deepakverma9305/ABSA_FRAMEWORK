package guiRun;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Link;

public class GUI {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(887, 560);
		shell.setText("SWT Application");
		
		
		
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(82, 32, 88, 15);
		lblNewLabel.setText("Available Test");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(513, 32, 75, 15);
		lblNewLabel_1.setText("Selected Test");
		
		List list = new List(shell, SWT.BORDER);
		list.setItems(new String[] {});
		list.setBounds(23, 79, 225, 316);
		int Str= list.getItemCount();
		 if(Str < 1)
			 
		 {
			 
			 list.add("Login Test", 0);
			 list.add("SRF_CreateTradeLoant", 1);
			 
			 
		 }
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(732, 92, 129, 256);
		lblNewLabel_3.setText("Guiding Messages");

		
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setItems(new String[] {});
		list_1.setBounds(431, 79, 254, 316);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
			
				try{
					int s2 = list_1.getFocusIndex();
				    String s3= list_1.getItem(s2);
				    
				   int Index=list.getItemCount();
				    
					list.add(s3,Index);				
					
					list_1.remove(s3);	}catch(Exception e1)   
					
					{
						
						e1.printStackTrace();
					
						lblNewLabel_3.setText("!!No Test Selected");
					
					} 
			
			
			}
		});
		btnNewButton_1.setBounds(295, 135, 75, 25);
		btnNewButton_1.setText("Remove Test");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try{
				int s2 = list.getFocusIndex();
			    String s3= list.getItem(s2);
			    
			    int Index=list_1.getItemCount();
				list_1.add(s3, Index);
				list.remove(s3);	}catch(Exception e1)   
				
				{
					
					e1.printStackTrace();
				
					lblNewLabel_3.setText("!!No Test Selected");
				
				} 
				
				
			}
		});
		btnNewButton_2.setBounds(295, 264, 75, 25);
		btnNewButton_2.setText("Select Test");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(252, 10, 193, 15);
		lblNewLabel_2.setText("ABSA AUTOMATED FRAMEWORK");
		
		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(82, 452, 533, 17);
		//progressBar.setSelection(40);
		
		Label lblProgress = new Label(shell, SWT.NONE);
		lblProgress.setBounds(20, 454, 55, 15);
		lblProgress.setText("Progress");
		
		Link link = new Link(shell, SWT.NONE);
		link.setToolTipText("");
		link.setTouchEnabled(true);
		link.setBounds(758, 42, 49, 15);
		link.setText("<a>www.google.com</a> ");
		
		
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				try {
					
					int Index=list_1.getItemCount();
					
					for(int i=0 ;i<=Index-1;i++)
						
						
					{
						String TestName= list_1.getItem(i);
						if(TestName.equals("Login Test"))
						
						{
							
							testCases.Login_Test.Test_Login("Test_Login");
							
							
						}
						
						
						if(TestName.equals("SRF_CreateTradeLoant"))
						{
							
							
							generalFunctions.Functions.CleanDB();
							generalFunctions.Functions.DeleteDBWF();
							testCases.SRF_CreateTradeLoan.SRFCreateTradeLoan();
							
							
						}
						
					}
					
					
				
				
				
				
				
				
				
				
				//
				
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(732, 444, 75, 25);
		btnNewButton.setText("Run Test");
		
		
	
	}
}
