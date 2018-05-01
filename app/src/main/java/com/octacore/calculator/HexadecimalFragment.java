package com.octacore.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HexadecimalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HexadecimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HexadecimalFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HexadecimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HexadecimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HexadecimalFragment newInstance(String param1, String param2) {
        HexadecimalFragment fragment = new HexadecimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //--------------Textview and button variables-----------------
    TextView myTextView, myTextView2;
    View boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0,
            botonA, botonB, botonC, botonD, botonE, botonF;

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
        View view = inflater.inflate(R.layout.fragment_hexadecimal, container, false);

        myTextView = view.findViewById(R.id.myTextView);
        myTextView.setText("");

        myTextView2 = view.findViewById(R.id.myTextView2);
        myTextView2.setText("");

        boton1 = view.findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        boton2 = view.findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        boton3 = view.findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        boton4 = view.findViewById(R.id.button4);
        boton4.setOnClickListener(this);
        boton5 = view.findViewById(R.id.button5);
        boton5.setOnClickListener(this);
        boton6 = view.findViewById(R.id.button6);
        boton6.setOnClickListener(this);
        boton7 = view.findViewById(R.id.button7);
        boton7.setOnClickListener(this);
        boton8 = view.findViewById(R.id.button8);
        boton8.setOnClickListener(this);
        boton9 = view.findViewById(R.id.button9);
        boton9.setOnClickListener(this);
        boton0 = view.findViewById(R.id.button0);
        boton0.setOnClickListener(this);
        botonA = view.findViewById(R.id.buttonA);
        botonA.setOnClickListener(this);
        botonB = view.findViewById(R.id.buttonB);
        botonB.setOnClickListener(this);
        botonC = view.findViewById(R.id.buttonC);
        botonC.setOnClickListener(this);
        botonD = view.findViewById(R.id.buttonD);
        botonD.setOnClickListener(this);
        botonE = view.findViewById(R.id.buttonE);
        botonE.setOnClickListener(this);
        botonF = view.findViewById(R.id.buttonF);
        botonF.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){

    }

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
