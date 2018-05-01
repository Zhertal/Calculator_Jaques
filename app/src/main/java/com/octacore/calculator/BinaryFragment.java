package com.octacore.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BinaryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BinaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BinaryFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //-------------------Button and Text view variables-----------------------------
    TextView myTextView, myTextView2;

    Button boton1;
    Button boton0;
    Button botonSuma;
    Button botonResta;
    Button botonMultiplica;
    Button botonDivide;
    Button botonIgual;
    Button botonBorra;
    Button botonConvHex;

    //------------------Functions variables-----------------------------------------
    boolean finalfraccion = false;
    int result, m1=0, m2=0, divisor = 0, numerador = 0, ResFraccion = 0;
    char op1='+';

    public BinaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BinaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BinaryFragment newInstance(String param1, String param2) {
        BinaryFragment fragment = new BinaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        View view = inflater.inflate(R.layout.fragment_binary, container, false);

        myTextView = (TextView) view.findViewById(R.id.myTextView);
        myTextView.setText("");
        myTextView2=(TextView) view.findViewById(R.id.myTextView2);
        myTextView2.setText("");

        boton1 = view.findViewById(R.id.btn1);
        boton1.setOnClickListener(this);
        boton0 = view.findViewById(R.id.btn0);
        boton0.setOnClickListener(this);
        botonSuma = view.findViewById(R.id.btnSuma);
        botonSuma.setOnClickListener(this);
        botonResta = view.findViewById(R.id.btnResta);
        botonResta.setOnClickListener(this);
        botonMultiplica = view.findViewById(R.id.btnMul);
        botonMultiplica.setOnClickListener(this);
        botonDivide = view.findViewById(R.id.btnDiv);
        botonDivide.setOnClickListener(this);
        botonIgual = view.findViewById(R.id.btnIg);
        botonIgual.setOnClickListener(this);
        botonBorra = view.findViewById(R.id.btnBorr);
        botonBorra.setOnClickListener(this);
        botonConvHex = view.findViewById(R.id.btnCHex);
        botonConvHex.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1)
            myTextView.append("1");
        else if(v.getId()==R.id.btn0)
            myTextView.append("0");
        else if(v.getId()==R.id.btnBorr){
            myTextView.setText("");
            myTextView2.setText("");
            op1='+';
            m1=0;
            m2=2;
            result=0;
        }
        else if(v.getId()==R.id.btnSuma) calcula('+');
        else if(v.getId()==R.id.btnResta) calcula('-');
        else if(v.getId()==R.id.btnMul) calcula('*');
        else if(v.getId()==R.id.btnDiv) calcula('/');
        else if(v.getId()==R.id.btnIg) calcula('=');
        else if(v.getId()==R.id.btnCHex) calcula('h');
    }

    public void calcula(char op){
        int numer1=0, numer2=0;
        String mn1, mn2;
        int result=m1;
        String cadena=myTextView.getText().toString();
        try{
            m2=Integer.parseInt(cadena);

            mn1 = String.valueOf(m1);
            mn2 = String.valueOf(m2);
            //Convertimos los binarios a decimal de m1
            long nbin = Long.parseLong(mn1);
            long ndec = 0;
            int cont=1;
            long auxd;
            while (nbin>0){
                auxd = nbin%2;
                ndec = ndec+auxd*cont;
                nbin /=10;//dividimos entre la base 10
                cont = cont*2;
                m1 = (int)ndec;
            }

            //Convertimos los binarios a decimal de m2
            long nbin2 = Long.parseLong(mn2);
            long ndec2 = 0;
            int cont2=1;
            long auxd2;

            while (nbin2>0){
                auxd2 = nbin2%2;
                ndec2 = ndec2+auxd2*cont2;
                nbin2 /=10;//dividimos entre la base 10
                cont2 = cont2*2;
                m2 = (int)ndec2;
            }
            if(op1=='+') result = m1 + m2;
            else if(op1=='-') result = m1-m2;
            else if(op1=='*') result = m1*m2;
            else if(op1=='/') result = m1/m2;
            else if(op1=='h'){
                result=12345;
            }

            //Convertir resultado a binario
            m1=result;
            op1=op;
            if(op== '='){
                m1 = -1*m1;
                long dec = m1;
                long aux = dec;
                String bina="";
                while(aux > 0) {
                    bina = aux % 2 + bina;
                    aux /= 2;
                }
                m1 = Integer.parseInt(bina);
                myTextView.setText(""+m1);
                myTextView2.setText(""+m1
                );

            }else{
                if(op1=='h'){
                    myTextView.setText(""+result);
                    myTextView2.setText(""+result);
                }else{
                    myTextView.setText("");
                    myTextView2.setText(""+Integer.parseInt(String.valueOf(mn2))+op1);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
