package com.prosper.day.applicationsupportclasses;

 /* ****************************************************************************
 /* Copyright (C) 2016 The Android Open Source Project
 /*
 /* Licensed under the Apache License, Version 2.0 (the "License");
 /* you may not use this file except in compliance with the License.
 /* You may obtain a copy of the License at
 /*
 /*     http://www.apache.org/licenses/LICENSE-2.0
 /*
 /* Unless required by applicable law or agreed to in writing, software
 /* distributed under the License is distributed on an "AS IS" BASIS,
 /* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 /* See the License for the specific language governing permissions and
 /* limitations under the License.
 /* ****************************************************************************
 /* Created by Rosemeire Deconti on 2019 / July
 /* ****************************************************************************/

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.prosper.day.R;

public class SupportPieChartRenderer extends PieChartRenderer {

    private final Context context;

    public SupportPieChartRenderer(PieChart chart, ChartAnimator animator,
                                   ViewPortHandler viewPortHandler) {

        super(chart, animator, viewPortHandler);
        context = chart.getContext();
    }

    @Override
    public void drawExtras(Canvas canvas) {
        super.drawExtras(canvas);

        drawImage(canvas);
    }

    private void drawImage(Canvas canvas) {

        MPPointF center = mChart.getCenterCircleBox();

        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.application_bitmap_small, null);

        if (drawable != null) {

            float halfWidth = drawable.getIntrinsicWidth() >> 1;
            float halfHeight = drawable.getIntrinsicHeight() >> 1;

            drawable.setBounds((int) (center.x - halfWidth), (int) (center.y - halfHeight), (int) (center.x + halfWidth), (int) (center.y + halfHeight));
            drawable.draw(canvas);

        }
    }
}
