package com.octacore.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StandardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StandardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandardFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StandardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandardFragment newInstance(String param1, String param2) {
        StandardFragment fragment = new StandardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //-------------Variables de botones y textviews-------------
    TextView myTextView;
    TextView myTextView2;
    Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0,
            botonSuma, botonResta, botonMultiplica, botonDivide, botonPunto,
            botonIgual, botonBorra,
            botonMod, botonExpo, botonCubo, botonRaiz, botonFact, botonFrac,
            botonA, botonB, botonC,
            botonFG, botonRNG;
    //----------Variables de ecuaciones y operaciones-----------
    boolean finalfraccion = false;
    float px1, px2, py1, py2;
    private GestureDetectorCompat gestureObject;
    double result, m1=0, m2=0, divisor = 0, numerador = 0, ResFraccion = 0;
    double a=0,b=0,c=0,d=0, x1=0, x2=0;
    char op1='+';
    String[] fraccion;
    Random r = new Random();
    int Xn = r.nextInt((500-1)+1)+10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_standard, container, false);

        myTextView = (TextView) view.findViewById(R.id.myTextView);
        myTextView.setText("");
        myTextView2 = (TextView) view.findViewById(R.id.myTextView2);
        myTextView2.setText("");

        boton1 = (Button) view.findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        boton2 = view.findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        boton3=view.findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        boton4=view.findViewById(R.id.button4);
        boton4.setOnClickListener(this);
        boton5=view.findViewById(R.id.button5);
        boton5.setOnClickListener(this);
        boton6=view.findViewById(R.id.button6);
        boton6.setOnClickListener(this);
        boton7=view.findViewById(R.id.button7);
        boton7.setOnClickListener(this);
        boton8=view.findViewById(R.id.button8);
        boton8.setOnClickListener(this);
        boton9=view.findViewById(R.id.button9);
        boton9.setOnClickListener(this);
        boton0=view.findViewById(R.id.button0);
        boton0.setOnClickListener(this);
        botonSuma=view.findViewById(R.id.buttonSuma);
        botonSuma.setOnClickListener(this);
        botonResta=view.findViewById(R.id.buttonResta);
        botonResta.setOnClickListener(this);
        botonMultiplica=view.findViewById(R.id.buttonMultiplica);
        botonMultiplica.setOnClickListener(this);
        botonDivide=view.findViewById(R.id.buttonDivide);
        botonDivide.setOnClickListener(this);
        botonPunto=view.findViewById(R.id.buttonPunto);
        botonPunto.setOnClickListener(this);
        botonIgual=view.findViewById(R.id.buttonIgual);
        botonIgual.setOnClickListener(this);
        botonBorra=view.findViewById(R.id.buttonBorra);
        botonBorra.setOnClickListener(this);
        botonMod = view.findViewById(R.id.buttonMod);
        botonMod.setOnClickListener(this);
        botonExpo = view.findViewById(R.id.buttonExpo);
        botonExpo.setOnClickListener(this);
        botonCubo = view.findViewById(R.id.buttonCubo);
        botonCubo.setOnClickListener(this);
        botonRaiz = view.findViewById(R.id.buttonRaiz);
        botonRaiz.setOnClickListener(this);
        botonFact = view.findViewById(R.id.buttonFact);
        botonFact.setOnClickListener(this);
        botonFrac = view.findViewById(R.id.buttonFrac);
        botonFrac.setOnClickListener(this);
        botonA = view.findViewById(R.id.buttonA);
        botonA.setOnClickListener(this);
        botonB = view.findViewById(R.id.buttonB);
        botonB.setOnClickListener(this);
        botonC = view.findViewById(R.id.buttonC);
        botonC.setOnClickListener(this);
        botonFG = view.findViewById(R.id.buttonFG);
        botonFG.setOnClickListener(this);
        botonRNG = view.findViewById(R.id.buttonRNG);
        botonRNG.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button1)
            myTextView.append("1");
        else if(view.getId()==R.id.button2)
            myTextView.append("2");
        else if(view.getId()==R.id.button3)
            myTextView.append("3");
        else if(view.getId()==R.id.button4)
            myTextView.append("4");
        else if(view.getId()==R.id.button5)
            myTextView.append("5");
        else if(view.getId()==R.id.button6)
            myTextView.append("6");
        else if(view.getId()==R.id.button7)
            myTextView.append("7");
        else if(view.getId()==R.id.button8)
            myTextView.append("8");
        else if(view.getId()==R.id.button9)
            myTextView.append("9");
        else if(view.getId()==R.id.button0)
            myTextView.append("0");
        else if(view.getId()==R.id.buttonPunto)
            myTextView.append(".");
        else if(view.getId()==R.id.buttonFrac) {
            finalfraccion = true;
            myTextView.append("/");
        }
        else if(view.getId()==R.id.buttonBorra){
            myTextView.setText("");
            myTextView2.setText("");
            m1=0;a=0;b=0;c=0;
            op1='+';
        }
        else if(view.getId()==R.id.buttonSuma) calcula('+');
        else if(view.getId()==R.id.buttonResta) calcula('-');
        else if(view.getId()==R.id.buttonMultiplica) calcula('*');
        else if(view.getId()==R.id.buttonDivide) calcula('/');
        else if(view.getId()==R.id.buttonIgual) calcula('=');
        else if(view.getId()==R.id.buttonExpo) calcula('^');
        else if(view.getId()==R.id.buttonCubo) calcula('³');
        else if(view.getId()==R.id.buttonRaiz) calcula('√');
        else if(view.getId()==R.id.buttonFact) calcula('!');

        else if(view.getId()==R.id.buttonA){
            String cadena = myTextView.getText().toString();
            a = Double.parseDouble(cadena);
            myTextView2.setText("a=" +a + " b="+b+" c="+c);
            myTextView.setText("");
            m1=0;
        }
        else if(view.getId()==R.id.buttonB){
            String cadena=myTextView.getText().toString();
            b = Double.parseDouble(cadena);
            myTextView2.setText("a=" +a + " b="+b+" c="+c);
            myTextView.setText("");
            m1=0;
        }
        else if(view.getId()==R.id.buttonC){
            String cadena=myTextView.getText().toString();
            c = Double.parseDouble(cadena);
            myTextView2.setText("a=" +a + " b="+b+" c="+c);
            myTextView.setText("");
            m1=0;
        }
        else if(view.getId()==R.id.buttonFG){
            if (a!=0 && b!=0 && c!=0){
                d= Math.pow(b,2) - 4*a*c;
                if(d<0){
                    myTextView.setText("NaN");
                    myTextView2.setText("NaN");
                }else{
                    x1 = (-b + Math.sqrt(d))/2*a;
                    x2 = (-b - Math.sqrt(d))/2*a;
                    myTextView.setText("x1="+x1);
                    myTextView2.setText("x2="+x2);
                    a=0;b=0;c=0;
                }
            }else
                Toast.makeText(getActivity(),"Faltan variables",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.buttonRNG){
            Xn = (81 * Xn + 89) % 500;
            myTextView.setText(""+Xn);
        }
    }

    public void calcula(char op){
        if(finalfraccion == true){
            String Fracciontemp = myTextView.getText().toString();
            fraccion = Fracciontemp.split("/");
            numerador = Double.parseDouble(fraccion[0]);
            divisor = Double.parseDouble(fraccion[1]);
            ResFraccion = numerador/divisor;
            myTextView.setText("");
            myTextView.setText(String.valueOf(ResFraccion));
            finalfraccion = false;
        }
        double result=m1;
        String cadena=myTextView.getText().toString();
        try{
            m2=Double.parseDouble(cadena);
            if(op1=='+') result=m1+m2;
            else if(op1=='-') result=m1-m2;
            else if(op1=='*') result=m1*m2;
            else if(op1=='/') result=m1/m2;
            else if(op1=='%'){
                result=m1%m2;
                if(result<0){
                    result = result * -1;
                }
            }
            else if(op1=='^') result=Math.pow(m1,m2);
            else if(op1=='³') {
                result=Math.pow(m1,3);
                myTextView.setText(""+result);
                myTextView2.setText(""+result);
            }
            else if(op1=='√') result=Math.sqrt(m1);
            else if(op1=='!'){
                result=1;
                if(m1<0){
                    Toast.makeText(getActivity(),"No existe :'v", Toast.LENGTH_SHORT).show();
                    result = 0;
                }else if(m1 == 0) result=1;
                else{
                    for(int i =1; i<=m1;i++){
                        result = result * i;
                    }
                }
            }

            m1=result;
            op1=op;
            if(op == '='){
                myTextView.setText(""+m1);
                myTextView2.setText(""+m1);
            }else{
                myTextView.setText("");
                myTextView2.setText(""+m1+op1);
                if(op1=='³' || op1=='√' || op1=='!'){
                    myTextView.setText(""+result);
                    myTextView2.setText(""+result);
                }
            }//else
        }catch(NumberFormatException nfe){
            Toast.makeText(getActivity(), "numero incorrecto", Toast.LENGTH_SHORT).show();
        }//catch
    }//calcula

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
