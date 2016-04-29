package com.yogi.spinginandroid.module.barcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.qrcode.QRCodeWriter;
import com.yogi.spinginandroid.DemoFragment;
import com.yogi.spinginandroid.MainActivity;
import com.yogi.spinginandroid.R;

/**
 * Created by ril on 4/29/16.
 */
public class BarcodeFragment extends DemoFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_barcode,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView image = (ImageView) view.findViewById(R.id.IMG_qrcode);

        FloatingActionButton fab1 = (FloatingActionButton) view.findViewById(R.id.FAB_generate_qr);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = new String("abcdefgh ij k");
                int width = image.getWidth();
                int height = image.getHeight();

                int side = width > height ? height: width;

                QRCodeWriter writer = new QRCodeWriter();
                try {
                    BitMatrix bm = writer.encode(str, BarcodeFormat.QR_CODE, side, side);
                    Bitmap ImageBitmap = Bitmap.createBitmap(side, side, Bitmap.Config.ARGB_8888);

                    for (int i = 0; i < side; i++) {//width
                        for (int j = 0; j < side; j++) {//height
                            ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK: Color.WHITE);
                        }
                    }
                    if (ImageBitmap != null) {
                        image.setImageBitmap(ImageBitmap);
                    } else {
                        Toast.makeText(getActivity(), "Null",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.FAB_scan_qr);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.initiateScan();
            }
        });

    }

}
