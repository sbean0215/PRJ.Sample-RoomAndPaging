package test.push.noti;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvItemDecoration extends RecyclerView.ItemDecoration {

    private final int pxBetweenItems;

    public RvItemDecoration(int dpBetweenItems, Context context) {
        this.pxBetweenItems = dpToPx(context, dpBetweenItems);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (0 == parent.getChildAdapterPosition(view))
            return;

        outRect.top = pxBetweenItems;
    }

    private int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension
                (TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
