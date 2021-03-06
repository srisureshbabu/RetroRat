package com.retrorat.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MonitorActivity extends MyActivity {

	private static final int REQUEST_DISCOVERY = 0x1;;
	private final String TAG = "MonitorActivity";
	private Handler _handler = new Handler();
	private final int maxlength = 2048;
	private BluetoothDevice device = null;
	private BluetoothSocket socket = null;
	
	private OutputStream outputStream;
	private InputStream inputStream;
	
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	private OnTouchListener OnTouchListener;
	public static boolean canRead = true;

	public static StringBuffer hexString = new StringBuffer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
				WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		this.getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.monitor);

		BluetoothDevice finalDevice = this.getIntent().getParcelableExtra(
				BluetoothDevice.EXTRA_DEVICE);
		SocketApplication app = (SocketApplication) getApplicationContext();
		device = app.getDevice();
		Log.d(TAG, "test1");
		if (finalDevice == null) {
			if (device == null) {
				Log.d(TAG, "test2");
				Intent intent = new Intent(this, SearchDeviceActivity.class);
				startActivity(intent);
				finish();
				return;
			}
			Log.d(TAG, "test4");
		} else if (finalDevice != null) {
			Log.d(TAG, "test3");
			app.setDevice(finalDevice);
			device = app.getDevice();
		}
		new Thread() {
			public void run() {
				connect(device);
			};
		}.start();
		
		final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.toggleButton1);
        togglebutton.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (togglebutton.isChecked()) {
					String relay1 = "c11";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send 1... ",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                } else {
                    String relay1 = "c10";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send 1... ",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                }
				// TODO Auto-generated method stub
			}
        });
        final ToggleButton togglebutton4 = (ToggleButton) findViewById(R.id.toggleButton4);
        togglebutton4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (togglebutton4.isChecked()) {
					String relay1 = "c41";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send 4... ",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                } else {
                    Toast.makeText(getBaseContext(), "Not checked", Toast.LENGTH_SHORT).show();
                    String relay1 = "c40";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send 4... ",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                }
				// TODO Auto-generated method stub
			}
        });
        final ToggleButton togglebutton5 = (ToggleButton) findViewById(R.id.toggleButton5);
        togglebutton5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (togglebutton5.isChecked()) {
					String relay1 = "c51";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 5",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                } else {
                    String relay1 = "c50";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 5",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                }
				// TODO Auto-generated method stub
			}
        });
        final ToggleButton togglebutton6 = (ToggleButton) findViewById(R.id.toggleButton6);
        togglebutton6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (togglebutton6.isChecked()) {
					String relay1 = "c61";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 6",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                } else {
                    String relay1 = "c60";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 6",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                }
				// TODO Auto-generated method stub
			}
        });
        final ToggleButton togglebutton7 = (ToggleButton) findViewById(R.id.toggleButton7);
        togglebutton7.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (togglebutton7.isChecked()) {
					String relay1 = "c71";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 7",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                } else {
                    String relay1 = "c70";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 7",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                }
				// TODO Auto-generated method stub
			}
        });
        final ToggleButton togglebutton8 = (ToggleButton) findViewById(R.id.toggleButton8);
        togglebutton8.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (togglebutton8.isChecked()) {
					String relay1 = "c81";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 8",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                } else {
                    String relay1 = "c80";
					try {
						if (outputStream != null) {
							synchronized (obj2) {
								outputStream.write(relay1.getBytes());
							}
						} else {
							Toast.makeText(getBaseContext(),
									"failed to send ... 8",
									Toast.LENGTH_SHORT).show();
						}
					} catch (IOException e) {
						Log.e(TAG, ">>", e);
						e.printStackTrace();
					}
                }
				// TODO Auto-generated method stub
			}
        });
        
        Button pushButton = (Button) findViewById(R.id.button1);
        pushButton.setOnTouchListener(startButtonListener);
        
        Button pushDriverButton = (Button) findViewById(R.id.toggleButton2);
        pushDriverButton.setOnTouchListener(driverDoorListener);
        
        Button pushPassengerButton = (Button) findViewById(R.id.toggleButton3);
        pushPassengerButton.setOnTouchListener(passengerDoorListener);
	}
	
	private OnTouchListener startButtonListener = new OnTouchListener(){
        public boolean onTouch(View v, MotionEvent event) {
           switch ( event.getAction() ) {
            case MotionEvent.ACTION_DOWN: 
            	String relay1 = "c11";
				try {
					if (outputStream != null) {
						synchronized (obj2) {
							outputStream.write(relay1.getBytes());
						}
					} else {
						Toast.makeText(getBaseContext(),
								"failed to send start... ",
								Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
					e.printStackTrace();
				}
				return false;
            case MotionEvent.ACTION_UP:
            	String relay2 = "c10";
				try {
					if (outputStream != null) {
						synchronized (obj2) {
							outputStream.write(relay2.getBytes());
						}
					} else {
						Toast.makeText(getBaseContext(),
								"failed to send ... ",
								Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
					e.printStackTrace();
				}
            }
           return false;
        }  
   };
   
   private OnTouchListener driverDoorListener = new OnTouchListener(){
       public boolean onTouch(View v, MotionEvent event) {
          switch ( event.getAction() ) {
           case MotionEvent.ACTION_DOWN: 
           	String relay1 = "c21";
				try {
					if (outputStream != null) {
						synchronized (obj2) {
							outputStream.write(relay1.getBytes());
						}
					} else {
						Toast.makeText(getBaseContext(),
								"failed to send start... ",
								Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
					e.printStackTrace();
				}
				return false;
           case MotionEvent.ACTION_UP:
           	String relay2 = "c20";
				try {
					if (outputStream != null) {
						synchronized (obj2) {
							outputStream.write(relay2.getBytes());
						}
					} else {
						Toast.makeText(getBaseContext(),
								"failed to send ... ",
								Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
					e.printStackTrace();
				}
           }
          return false;
       }  
  };
  
  private OnTouchListener passengerDoorListener = new OnTouchListener(){
      public boolean onTouch(View v, MotionEvent event) {
         switch ( event.getAction() ) {
          case MotionEvent.ACTION_DOWN: 
          	String relay1 = "c31";
				try {
					if (outputStream != null) {
						synchronized (obj2) {
							outputStream.write(relay1.getBytes());
						}
					} else {
						Toast.makeText(getBaseContext(),
								"failed to send start... ",
								Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
					e.printStackTrace();
				}
				return false;
          case MotionEvent.ACTION_UP:
          	String relay2 = "c30";
				try {
					if (outputStream != null) {
						synchronized (obj2) {
							outputStream.write(relay2.getBytes());
						}
					} else {
						Toast.makeText(getBaseContext(),
								"failed to send ... ",
								Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
					e.printStackTrace();
				}
          }
         return false;
      }  
 };

	/* after select, connect to device */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode != REQUEST_DISCOVERY) {
			finish();
			return;
		}
		if (resultCode != RESULT_OK) {
			finish();
			return;
		}
		final BluetoothDevice device = data
				.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
		new Thread() {
			public void run() {
				connect(device);
			};
		}.start();
	}

	protected void onDestroy() {
		super.onDestroy();
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			Log.e(TAG, ">>", e);
		}
	}

	protected void connect(BluetoothDevice device) {
		try {
			Log.d(TAG, "��������");
			// Create a Socket connection: need the server's UUID number of
			// registered
			Method m = device.getClass().getMethod("createRfcommSocket",
					new Class[] { int.class });
			socket = (BluetoothSocket) m.invoke(device, 1);
			socket.connect();
			Log.d(TAG, ">>Client connectted");
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			int read = -1;
			final byte[] bytes = new byte[2048];
			while (true) {
				synchronized (obj1) {
					read = inputStream.read(bytes);
					Log.d(TAG, "read:" + read);
					if (read > 0) {
						final int count = read;
						String str = SamplesUtils.byteToHex(bytes, count);
//						Log.d(TAG, "test1:" + str);
						String hex = hexString.toString();
						if (hex == "") {
							hexString.append("<--");
						} else {
							if (hex.lastIndexOf("<--") < hex.lastIndexOf("-->")) {
								hexString.append("\n<--");
							}
						}
						hexString.append(str);
						hex = hexString.toString();
//						Log.d(TAG, "test2:" + hex);
						if (hex.length() > maxlength) {
							try {
								hex = hex.substring(hex.length() - maxlength,
										hex.length());
								hex = hex.substring(hex.indexOf(" "));
								hex = "<--" + hex;
								hexString = new StringBuffer();
								hexString.append(hex);
							} catch (Exception e) {
								e.printStackTrace();
								Log.e(TAG, "e", e);
							}
						}
						_handler.post(new Runnable() {
							public void run() {
							}
						});
					}
				}
			}

		} catch (Exception e) {
			Log.e(TAG, ">>", e);
			Toast.makeText(getBaseContext(),
					getResources().getString(R.string.ioexception),
					Toast.LENGTH_SHORT).show();
			return;
		} finally {
			if (socket != null) {
				try {
					Log.d(TAG, ">>Client Socket Close");
					socket.close();
					socket = null;
					// this.finish();
					return;
				} catch (IOException e) {
					Log.e(TAG, ">>", e);
				}
			}
		}
	}
}