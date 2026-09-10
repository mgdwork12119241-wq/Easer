package ryey.easer.core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ryey.easer.core.ui.data.profile.EditProfileActivity;

public class ReadyAutomationsFragment extends Fragment {

    public ReadyAutomationsFragment() {
        super();
    }

    @Override
    public View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container,
                             Bundle savedInstanceState) {
        android.content.Context context = requireContext();
        ScrollView scroll = new ScrollView(context);
        LinearLayout root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(18), dp(20), dp(24));
        scroll.addView(root);

        TextView title = text("أتمتات جاهزة", 26, true);
        root.addView(title, params(-1, -2));

        TextView intro = text("أفكار جاهزة تساعدك تبدأ بسرعة. اضغط على إنشاء لفتح محرر الأتمتة وبناء الملف المناسب لك.", 15, false);
        intro.setPadding(0, dp(6), 0, dp(18));
        root.addView(intro, params(-1, -2));

        addCard(root, "🌙 وضع النوم", "وقت النوم: جهّز الهاتف للوضع الهادئ وخفّف الإزعاج.");
        addCard(root, "🔋 توفير البطارية", "عند انخفاض البطارية: نفّذ إجراءات تساعد على إطالة الاستخدام.");
        addCard(root, "🔌 عند الشحن", "عند توصيل الشاحن: شغّل الإجراءات التي تريدها تلقائياً.");
        addCard(root, "🚗 وضع السيارة", "عند استخدام الهاتف في السيارة: جهّز تجربة القيادة المناسبة.");
        addCard(root, "☀️ روتين الصباح", "في وقت الصباح: شغّل سلسلة الإجراءات التي تناسب بداية يومك.");
        addCard(root, "🎧 عند توصيل السماعات", "عند توصيل السماعات: نفّذ إجراءات الوسائط التي تختارها.");
        addCard(root, "🏠 الوصول إلى المنزل", "عند الوصول: فعّل إعدادات المنزل التي تدعمها قدرات جهازك.");
        addCard(root, "💼 وقت العمل", "في ساعات العمل: جهّز الهاتف بطريقة مناسبة للعمل والتركيز.");

        TextView note = text("ملاحظة: هذه النسخة تعرض قوالب البداية فقط؛ لن نضيف أي إجراء غير مدعوم فعلياً من Easer. سنحوّل القوالب إلى أتمتات قابلة للتثبيت خطوة بخطوة بعد اختبار النسخة التجريبية.", 13, false);
        note.setPadding(0, dp(16), 0, 0);
        root.addView(note, params(-1, -2));

        return scroll;
    }

    private void addCard(LinearLayout root, String name, String description) {
        LinearLayout card = new LinearLayout(requireContext());
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));
        card.setBackgroundResource(android.R.drawable.dialog_holo_light_frame);

        TextView title = text(name, 18, true);
        card.addView(title, params(-1, -2));
        TextView desc = text(description, 14, false);
        desc.setPadding(0, dp(5), 0, dp(8));
        card.addView(desc, params(-1, -2));

        Button create = new Button(requireContext());
        create.setText("إنشاء أتمتة");
        create.setOnClickListener(v -> startActivity(new Intent(requireContext(), EditProfileActivity.class)));
        LinearLayout.LayoutParams buttonParams = params(-2, -2);
        buttonParams.gravity = Gravity.END;
        card.addView(create, buttonParams);

        LinearLayout.LayoutParams cardParams = params(-1, -2);
        cardParams.setMargins(0, 0, 0, dp(12));
        root.addView(card, cardParams);
    }

    private TextView text(String value, int size, boolean bold) {
        TextView view = new TextView(requireContext());
        view.setText(value);
        view.setTextSize(size);
        if (bold) view.setTypeface(view.getTypeface(), android.graphics.Typeface.BOLD);
        return view;
    }

    private LinearLayout.LayoutParams params(int width, int height) {
        return new LinearLayout.LayoutParams(width, height);
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }
}
