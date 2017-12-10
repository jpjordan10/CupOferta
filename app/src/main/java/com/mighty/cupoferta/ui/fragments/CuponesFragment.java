package com.mighty.cupoferta.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mighty.cupoferta.adapter.CuponAdapter;
import com.mighty.cupoferta.R;
import com.mighty.cupoferta.model.Coupon;
import com.mighty.cupoferta.ui.OnNavListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CuponesFragment extends Fragment {
    private String urlCupones = "http://192.168.1.42:3000/db/";
    private RecyclerView recyclerView;
    private CuponAdapter adapter;
    private boolean puedeCargar = false;

    private String nextUrl = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavListener mListener;

    public CuponesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CuponesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CuponesFragment newInstance(String param1, String param2) {
        CuponesFragment fragment = new CuponesFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_cupones, container,
                false);
        getActivity().setTitle(R.string.inicio);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view);
        adapter = new CuponAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                super.onScrolled(rv, dx, dy);
                if (dy > 0) {
                    int itemsVisibles = rv.getLayoutManager().getChildCount();
                    int itemsTotales = rv.getLayoutManager().getItemCount();
                    int primerItemVisible = ((GridLayoutManager) rv.getLayoutManager()).findFirstVisibleItemPosition();
                    if (puedeCargar) {
                        if (itemsVisibles + primerItemVisible >= itemsTotales) {
                            puedeCargar = false;
                            getObtenerCupones(nextUrl);
                        }
                    }
                }
            }
        });
        getObtenerCupones(urlCupones);
        return rootView;
    }

    private void getObtenerCupones(String urlActual) {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlActual,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //nextUrl = response.getString("next");
                            JSONArray jsonArrayCupones = response.getJSONArray("cupones");
                            if (jsonArrayCupones.length() > 0) {
                                List<Coupon> miListaCupon = new ArrayList<>();
                                puedeCargar = true;
                                for (int i = 0; i < jsonArrayCupones.length(); i++) {
                                    JSONObject jsonCupon = jsonArrayCupones.getJSONObject(i);
                                    final String titulo = jsonCupon.getString("titulo");
                                    final String empresa = jsonCupon.getString("empresa");
                                    final String descripcion = jsonCupon.getString("descripcion");
                                    final Coupon nuevoCupon = new Coupon(empresa, titulo, descripcion);
                                    miListaCupon.add(nuevoCupon);
                                }

                                adapter.setAddListCupones(miListaCupon);
                            }
                        } catch (JSONException je) {
                            puedeCargar = true;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavListener) {
            mListener = (OnNavListener) context;
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
}
