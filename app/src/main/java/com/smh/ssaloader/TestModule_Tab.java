package com.smh.ssaloader;

/**
 * Created by sarda on 10/12/2016.
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class TestModule_Tab  extends Fragment {

    int flagCurrentBoard;

Spinner TestModuleSpinner;
  protected   ArrayAdapter SpinnerArrayAdapterTEstModule;
    private String[] arraySpinnerTestModuleValues = new String[] {"P1 Board", "P2 Board", "P3 Board", "P4 Board","P5 Board"};
    TabHost mTabHost;
    ///////////////////////FOR ZOOMING ///////////////////////

    private Animator mCurrentAnimator;

    /**
     * The system "short" animation time duration, in milliseconds. This duration is ideal for
     * subtle animations or animations that occur very frequently.
     */
    private int mShortAnimationDuration;
    int selectedRadioButtonIDF3High,selectedRadioButtonIDF3Low,selectedRadioButtonIDF4High,selectedRadioButtonIDF4Low;

     ImageView expandedImageView;
     LinearLayout p2DSLRPICSLAYOUT;

    /////////////////////////// FOR ZOOMING ///////////////////////

    ImageView upfastf3IV,upslowf3IV,downfastf4IV,downslowf4IV,e26LockIV,e27UnlockIV;


RadioButton manualRB,automaticRB;

    ImageButton P2manualHoistTabBtn,P2manualGunTabBtn;
    ImageButton P2ThumbImageButtonSchematic,P2ThumbImageButtonPCB,P2ThumbImageButtonBoard;
CheckBox P2OperationUpFastF3CB,P2OperationUpSlowF3CB,P2OperationDownFastF4CB,P2OperationalDownSlowF4CB,P2OperationlGUNLOCke26CB,P2OperationlGUNUNLOCke27CB;
CheckBox P2HoistIndividualF3HighCB,P2HoistIndividualF3LowCB,P2HoistIndividualF4HighCB,P2HoistIndividualF4LowCB,P2IndividualGUNLocke26CB,P2IndividualGUNUNLocke27CB;
    LinearLayout F3HighResultLayout,F3LowResultLayout,F4HighResultLayout,F4LowResultLayout,GunLockE26Layout,GunUnLockE27Layout;
    RadioButton F3HighRBON,F3HighRBOFF,F3LowRBON,F3LowRBOFF,F4HighRBON,F4LowRBON,F4LowRBOFF,downf3slowRBOFF;
    RadioButton GunLockE26RBON,GunLockE26RBOFF,GunUnLockE27RBON,GunUnLockE27RBOFF;
    //////////////////////////////FOR P2 HOist testing Buttons//////////////////////////////////
ImageButton P2manualHoistTestbtn,P2manualHoistDebugbtn,P2manualHoistResetbtn;
RadioGroup F3HighRG,F3LowRG,F4HighRG,F4LowRG,E26LockRG,E27UnLockRG;
    ////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////FOR P2 GUn testing Buttons//////////////////////////////////

    ImageButton P2manualGunTestbtn,P2manualGunDebugbtn,P2manualGunResetbtn;
    ImageView P2manualMainDebugPicture;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

Button BtnBackForP2board,BtnProceedForP2Board;
    private RadioButton F4HighRBOFF;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.testmodule_tab, container, false);
        TestModuleSpinner=(Spinner)rootView.findViewById(R.id.Testmodule_boards_spinner);
       spinner_fn(arraySpinnerTestModuleValues,TestModuleSpinner,SpinnerArrayAdapterTEstModule);
        automaticRB=(RadioButton)rootView.findViewById(R.id.radioButton_auto);
        manualRB=(RadioButton)rootView.findViewById(R.id.radioButton_manual);
        p2DSLRPICSLAYOUT=(LinearLayout)rootView.findViewById(R.id.p2_dslr_pics_layout_id);
        FrameLayout testModule_framelayout=(FrameLayout)rootView.findViewById(R.id.testmodule_framelayout_id);
        final  LinearLayout MainTestModuleTabDivision=(LinearLayout)rootView.findViewById(R.id.main_testmodule_tab_id);
        final  LinearLayout P2BoardmanualTabs=(LinearLayout)testModule_framelayout.findViewById(R.id.p2board_manual_tabs_layout_id);
        final  LinearLayout P2BoardmanualTabs_Hoist=(LinearLayout)testModule_framelayout.findViewById(R.id.p2_manual_hoist_id);
        final  LinearLayout P2BoardmanualTabs_Gun=(LinearLayout)testModule_framelayout.findViewById(R.id.p2_manual_gun_id);
        final  LinearLayout P2BoardmanualTabs_Hoist_TestsBtns=(LinearLayout)testModule_framelayout.findViewById(R.id.p2_manual_hoist_testsBTNs);
        final  LinearLayout P2BoardmanualTabs_Gun_TestsBtns=(LinearLayout)testModule_framelayout.findViewById(R.id.p2_manual_Gun_testsBTNs);
/////////////////////////////////////////////////// Image Views////////////////////////////////

        upfastf3IV=(ImageView)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_upf3fast_result_led);
        upslowf3IV=(ImageView)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_upf3slow_result_led);
        downfastf4IV=(ImageView)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_downf4fast_result_led);
        downslowf4IV=(ImageView)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_downf4slow_result_led);
e26LockIV=(ImageView)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_operational_e26lock_result_led);
        e27UnlockIV=(ImageView)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_operational_e27unlock_result_led);




        //////////////////////////////////////////////Image Views////////////////////////////////
        expandedImageView = (ImageView)p2DSLRPICSLAYOUT.findViewById(R.id.expanded_image);
        P2manualMainDebugPicture = (ImageView)p2DSLRPICSLAYOUT.findViewById(R.id.p2_debug_image);
        BtnBackForP2board=(Button)p2DSLRPICSLAYOUT.findViewById(R.id.btn_back_for_p2_board);
        BtnProceedForP2Board=(Button)p2DSLRPICSLAYOUT.findViewById(R.id.btn_Proceed_for_p2_board);
        HoistTurnOFFOperationalLeds();
        P2OperationUpFastF3CB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_upfastf3_checkbox);
        P2OperationUpSlowF3CB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_upslowf3_checkbox);
        P2OperationDownFastF4CB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_downfastf4_checkbox);
        P2OperationalDownSlowF4CB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_operational_downslowf4_checkbox);
        P2HoistIndividualF3HighCB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3High_checkbox);
        P2HoistIndividualF3LowCB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3Low_checkbox);
        P2HoistIndividualF4HighCB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4High_checkbox);
       P2HoistIndividualF4LowCB=(CheckBox)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4Low_checkbox);
        F3HighResultLayout=(LinearLayout)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3High_result_layout);
        F3LowResultLayout=(LinearLayout)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3Low_result_layout);
        F4HighResultLayout=(LinearLayout)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4High_result_layout);
        F4LowResultLayout=(LinearLayout)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4Low_result_layout);

        GunLockE26Layout=(LinearLayout)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_locke26_result_layout);
        GunUnLockE27Layout=(LinearLayout)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_unlocke27_result_layout);


        ///// RAdio Buttons

        E26LockRG=(RadioGroup)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_LockE26_radioGroup);
        E27UnLockRG=(RadioGroup)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_UnLockE27_radioGroup);
        F3HighRG=(RadioGroup)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3High_radioGroup);
        F3LowRG=(RadioGroup)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3Low_radioGroup);
        F4HighRG=(RadioGroup)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4High_radioGroup);
        F4LowRG=(RadioGroup)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4Low_radioGroup);
        F3HighRBON=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3High_radio_ON);
        F3HighRBOFF=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3High_radio_OFF);
        F3LowRBON =(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3Low_radio_ON);
        F3LowRBOFF=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F3Low_radio_OFF);
        F4HighRBON=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4High_radio_ON);
        F4HighRBOFF=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4High_radio_OFF);
        F4LowRBON=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4Low_radio_ON);
        F4LowRBOFF=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_individual_F4Low_radio_OFF);


        GunLockE26RBON=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_locke26_radio_ON);
        GunLockE26RBOFF=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_locke26_radio_OFF);
        GunUnLockE27RBON=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_unlocke27_radio_ON);
        GunUnLockE27RBOFF=(RadioButton)P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_individual_unlocke27_radio_OFF);

        P2manualHoistTabBtn=(ImageButton) P2BoardmanualTabs.findViewById(R.id.p2_manual_hoist_tab_btn);
        P2manualGunTabBtn=(ImageButton) P2BoardmanualTabs.findViewById(R.id.p2_manual_gun_tab_btn);
        P2OperationlGUNLOCke26CB=(CheckBox)P2BoardmanualTabs_Gun.findViewById(R.id.p2_manual_gun_operational_locke26_checkbox);
        P2OperationlGUNUNLOCke27CB=(CheckBox)P2BoardmanualTabs_Gun.findViewById(R.id.p2_manual_gun_operational_unlocke27_checkbox);
        P2IndividualGUNLocke26CB=(CheckBox)P2BoardmanualTabs_Gun.findViewById(R.id.p2_manual_gun_individual_locke26_checkbox);
        P2IndividualGUNUNLocke27CB=(CheckBox)P2BoardmanualTabs_Gun.findViewById(R.id.p2_manual_gun_individual_unlocke27_checkbox);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        P2manualHoistTestbtn=(ImageButton)P2BoardmanualTabs_Hoist_TestsBtns.findViewById(R.id.P2manualHoistTestbtn_id);
        P2manualHoistDebugbtn=(ImageButton)P2BoardmanualTabs_Hoist_TestsBtns.findViewById(R.id.P2manualHoistDebugbtn_id);
        P2manualHoistResetbtn=(ImageButton)P2BoardmanualTabs_Hoist_TestsBtns.findViewById(R.id.P2manualHoistResetbtn_id);

        P2manualGunTestbtn=(ImageButton)P2BoardmanualTabs_Gun_TestsBtns.findViewById(R.id.P2manualGunTestbtn_id);
        P2manualGunDebugbtn=(ImageButton)P2BoardmanualTabs_Gun_TestsBtns.findViewById(R.id.P2manualGunDebugbtn_id);
        P2manualGunResetbtn=(ImageButton)P2BoardmanualTabs_Gun_TestsBtns.findViewById(R.id.P2manualGunResetbtn_id);
        P2ThumbImageButtonSchematic=(ImageButton)p2DSLRPICSLAYOUT.findViewById(R.id.p2_thumb_button_schematic);
        P2ThumbImageButtonPCB=(ImageButton)p2DSLRPICSLAYOUT.findViewById(R.id.p2_thumb_button_PCB);
        P2ThumbImageButtonBoard=(ImageButton)p2DSLRPICSLAYOUT.findViewById(R.id.p2_thumb_button_PCB);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        F3HighResultLayout.setVisibility(View.GONE);
        F3LowResultLayout.setVisibility(View.GONE);
        F4HighResultLayout.setVisibility(View.GONE);
        F4LowResultLayout.setVisibility(View.GONE);
        GunLockE26Layout.setVisibility(View.GONE);
        GunUnLockE27Layout.setVisibility(View.GONE);




        //////////////////////////////////////////// Buttons for P2 Schematic ,PCB,Board ///////////////////////////////

        final View P2BoardWithComponents_ThumbView =(View)p2DSLRPICSLAYOUT.findViewById(R.id.p2_thumb_button_Board);
        P2BoardWithComponents_ThumbView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(P2BoardWithComponents_ThumbView, R.drawable.p2_board_hd);
            }
        });

        final View P2BoardWithOutComponents_ThumbView =(View)p2DSLRPICSLAYOUT.findViewById(R.id.p2_thumb_button_PCB);
        P2BoardWithOutComponents_ThumbView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(P2BoardWithOutComponents_ThumbView, R.drawable.p2_pcb_hd);
            }
        });
        final View P2BoardSchematicMainButton =(View)p2DSLRPICSLAYOUT.findViewById(R.id.p2_thumb_button_schematic);
        P2BoardSchematicMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(P2OperationUpFastF3CB.isChecked()==true)
                {

                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoistf3_high_dslr_schematic_main);

                }
               else if(P2OperationUpSlowF3CB.isChecked()==true)
                {

                    if(flagCurrentBoard==0)
                    {
        // F4 LOW
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4low_dslr_schematic_main);
                    }
                    else
                    {
                        //F3 HIGH
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoistf3_high_dslr_schematic_main);
                    }


                }
                else if(P2OperationDownFastF4CB.isChecked()==true)
                {

                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4_high_dslr_schematic_main);

                }
                else if(P2OperationalDownSlowF4CB.isChecked()==true)
                {

                    if(flagCurrentBoard==0)
                    {
                        // F4 High
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4_high_dslr_schematic_main);
                    }
                    else
                    {
                        //F3 Low
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f3_low_dslr_schematic_main);
                    }

                }
                else if(P2HoistIndividualF3HighCB.isChecked()==true && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F3 HIGH
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoistf3_high_dslr_schematic_main);

                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==true && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==false)
                {
// F3LOW
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f3_low_dslr_schematic_main);

                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==true && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F4High
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4_high_dslr_schematic_main);

                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==true)
                {
//F4 LOW
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4low_dslr_schematic_main);
                }
                else if(P2HoistIndividualF3HighCB.isChecked()==true && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==true)
                {
//F3 HIgh,F4 Low
                    if(flagCurrentBoard==0)
                    {
                        // F4 LOW
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4low_dslr_schematic_main);
                    }
                    else
                    {
                        //F3 HIGH
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoistf3_high_dslr_schematic_main);
                    }


                }
                else if(P2HoistIndividualF3HighCB.isChecked()==true && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==true && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F4 HIgh,F3 High

                    if(flagCurrentBoard==0)
                    {
                        // F4 High
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4_high_dslr_schematic_main);
                    }
                    else
                    {
                        //F3 HIGH
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoistf3_high_dslr_schematic_main);
                    }



                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==true && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==true)
                {
//F3 Low,F4 Low

                    if(flagCurrentBoard==0)
                    {
                        // F4 Low
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4low_dslr_schematic_main);
                    }
                    else
                    {
                        //F3 Low
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f3_low_dslr_schematic_main);
                    }




                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==true && P2HoistIndividualF4HighCB.isChecked()==true && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F3 Low,F4 High

                    if(flagCurrentBoard==0)
                    {
                        // F4 High
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f4_high_dslr_schematic_main);
                    }
                    else
                    {
                        //F3 Low
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_hoist_f3_low_dslr_schematic_main);
                    }

                }
                else if(P2OperationlGUNLOCke26CB.isChecked()==true )
                {
//Gun Lock e26






                        //e26
                        zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_gun_lock_e26_dslr_schematicmain);


                }
                else if(P2OperationlGUNUNLOCke27CB.isChecked()==true )
                {
//Gun UnLock e27

                    // e27
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_gun_un_locke27_dslr_schematic_main);

                }
                else if(P2IndividualGUNLocke26CB.isChecked()==true )
                {
//Gun indi Lock e26

                    //e26
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_gun_lock_e26_dslr_schematicmain);


                }
                else if(P2IndividualGUNUNLocke27CB.isChecked()==true )
                {
//Gun indi UNLock e27

                    // e27
                    zoomImageFromThumb( P2BoardSchematicMainButton, R.drawable.p2_manual_gun_un_locke27_dslr_schematic_main);

                }



            }
        });
        // Retrieve and cache the system's default "short" animation time.
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





        P2manualHoistTabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P2manualHoistTabBtn.setBackground(getResources().getDrawable(R.drawable.hoist_open));
                P2manualGunTabBtn.setBackground(getResources().getDrawable(R.drawable.gun_close));

                P2BoardmanualTabs_Gun.setVisibility(View.GONE);
                P2BoardmanualTabs_Hoist.setVisibility(View.VISIBLE);
            }
        });


        P2manualGunTabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                P2manualHoistTabBtn.setBackground(getResources().getDrawable(R.drawable.hoist_close));
                P2manualGunTabBtn.setBackground(getResources().getDrawable(R.drawable.gun_open));
                P2BoardmanualTabs_Hoist.setVisibility(View.GONE);
                e26LockIV.setVisibility(View.GONE);
                        e27UnlockIV.setVisibility(View.GONE);
                P2BoardmanualTabs_Gun.setVisibility(View.VISIBLE);
            }
        });

        P2OperationUpFastF3CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if( P2OperationUpFastF3CB.isChecked()==true) {
    HoistTurnOFFOperationalLeds();
    P2OperationUpSlowF3CB.setChecked(false);
    P2OperationDownFastF4CB.setChecked(false);
    P2OperationalDownSlowF4CB.setChecked(false);
    P2HoistIndividualF3HighCB.setChecked(false); //F3 High
    P2HoistIndividualF3LowCB.setChecked(false);
    P2HoistIndividualF4HighCB.setChecked(false);
    P2HoistIndividualF4LowCB.setChecked(false);
    upfastf3IV.setVisibility(View.VISIBLE);

    HoistTurnOFFLayoutIndividual();

}
                else
{
    upfastf3IV.setVisibility(View.GONE);
}
//                HoistTurnOFFRadioButton();


            }
        });
        P2OperationUpSlowF3CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(P2OperationUpSlowF3CB.isChecked()==true) {
                    HoistTurnOFFOperationalLeds();
                    P2OperationUpFastF3CB.setChecked(false);
                    P2OperationDownFastF4CB.setChecked(false);
                    P2OperationalDownSlowF4CB.setChecked(false);
                    P2HoistIndividualF3HighCB.setChecked(false);
                    P2HoistIndividualF3LowCB.setChecked(false);
                    P2HoistIndividualF4HighCB.setChecked(false);
                    P2HoistIndividualF4LowCB.setChecked(false);
                    HoistTurnOFFLayoutIndividual();
                    upslowf3IV.setVisibility(View.VISIBLE);
                    HoistTurnOFFRadioButton();

                }
                else
                {
                    upslowf3IV.setVisibility(View.GONE);
                }
            }
        });
        P2OperationDownFastF4CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(P2OperationDownFastF4CB.isChecked()==true) {
                    HoistTurnOFFOperationalLeds();
                    P2OperationUpFastF3CB.setChecked(false);
                    P2OperationalDownSlowF4CB.setChecked(false);
                    P2OperationUpSlowF3CB.setChecked(false);
                    P2HoistIndividualF3HighCB.setChecked(false);
                    P2HoistIndividualF3LowCB.setChecked(false);
                    P2HoistIndividualF4HighCB.setChecked(false);
                    P2HoistIndividualF4LowCB.setChecked(false);
                    HoistTurnOFFLayoutIndividual();
                    downfastf4IV.setVisibility(View.VISIBLE);
                    HoistTurnOFFRadioButton();
                }

                else
                {

                    downfastf4IV.setVisibility(View.GONE);
                }
            }


        });

        P2OperationalDownSlowF4CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(P2OperationalDownSlowF4CB.isChecked()==true) {
                    HoistTurnOFFOperationalLeds();

                    P2OperationUpFastF3CB.setChecked(false);
                    P2OperationDownFastF4CB.setChecked(false);
                    P2OperationUpSlowF3CB.setChecked(false);
                    P2HoistIndividualF3HighCB.setChecked(false);
                    P2HoistIndividualF3LowCB.setChecked(false);
                    P2HoistIndividualF4HighCB.setChecked(false);
                    P2HoistIndividualF4LowCB.setChecked(false);
                    F3HighResultLayout.setVisibility(View.GONE);
                    F3LowResultLayout.setVisibility(View.GONE);
                    F4HighResultLayout.setVisibility(View.GONE);
                    F4LowResultLayout.setVisibility(View.GONE);
                    HoistTurnOFFLayoutIndividual();
                    downslowf4IV.setVisibility(View.VISIBLE);
                    HoistTurnOFFRadioButton();
                }
                else
                {
                    downslowf4IV.setVisibility(View.GONE);
                }
            }
        });

        P2HoistIndividualF3HighCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if(P2HoistIndividualF3HighCB.isChecked()== true)
{
    F3HighRG.clearCheck();


    HoistTurnOFFOperationalLeds();
    //   P2HoistIndividualF3LowCB.setChecked(false);
    P2OperationUpFastF3CB.setChecked(false);
    P2OperationDownFastF4CB.setChecked(false);
    P2OperationUpSlowF3CB.setChecked(false);
    P2OperationalDownSlowF4CB.setChecked(false);
    P2HoistIndividualF3LowCB.setChecked(false);
    F3LowResultLayout.setVisibility(View.GONE);

    F3HighResultLayout.setVisibility(View.VISIBLE);


}
                else
{

    F3HighResultLayout.setVisibility(View.GONE);


}





            }
        });
        P2HoistIndividualF3LowCB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

if(P2HoistIndividualF3LowCB.isChecked() ==true) {

    HoistTurnOFFOperationalLeds();
    P2OperationUpFastF3CB.setChecked(false);
    P2OperationDownFastF4CB.setChecked(false);
    P2OperationUpSlowF3CB.setChecked(false);
    P2OperationalDownSlowF4CB.setChecked(false);

    P2HoistIndividualF3HighCB.setChecked(false);
    F3LowRG.clearCheck();

    F3HighResultLayout.setVisibility(View.GONE);

    F3LowResultLayout.setVisibility(View.VISIBLE);

}

                else
{

    F3LowResultLayout.setVisibility(View.GONE);
}



            }
        });
        P2HoistIndividualF4HighCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if( P2HoistIndividualF4HighCB.isChecked()==true) {

    HoistTurnOFFOperationalLeds();
    P2OperationUpFastF3CB.setChecked(false);
    P2OperationDownFastF4CB.setChecked(false);
    P2OperationUpSlowF3CB.setChecked(false);

    P2OperationalDownSlowF4CB.setChecked(false);
F4HighRG.clearCheck();


    P2HoistIndividualF4LowCB.setChecked(false);
    F4LowResultLayout.setVisibility(View.GONE);


    F4HighResultLayout.setVisibility(View.VISIBLE);
    //   F4LowResultLayout.setVisibility(View.VISIBLE);
}
                else {
    F4HighResultLayout.setVisibility(View.GONE);

}

            }
        });
        P2HoistIndividualF4LowCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


if( P2HoistIndividualF4LowCB.isChecked()==true) {
    HoistTurnOFFOperationalLeds();
    P2OperationUpFastF3CB.setChecked(false);
    P2OperationDownFastF4CB.setChecked(false);
    P2OperationUpSlowF3CB.setChecked(false);
    P2HoistIndividualF4HighCB.setChecked(false);
    F4LowRG.clearCheck();



    F4HighResultLayout.setVisibility(View.GONE);
    //  P2HoistIndividualF4HighCB.setChecked(false);
    P2OperationalDownSlowF4CB.setChecked(false);

    F4LowResultLayout.setVisibility(View.VISIBLE);
}
                else
{

    F4LowResultLayout.setVisibility(View.GONE);
}

            }
        });






        P2OperationlGUNLOCke26CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(P2OperationlGUNLOCke26CB.isChecked())
                {

                    P2OperationlGUNUNLOCke27CB.setChecked(false);
                    P2IndividualGUNLocke26CB.setChecked(false);
                    P2IndividualGUNUNLocke27CB.setChecked(false);

                    GunTurnOFFRadioButton();
                    E26LockRG.clearCheck();
                    E27UnLockRG.clearCheck();
                    e26LockIV.setVisibility(View.VISIBLE);
                }
              else
                {
                    e26LockIV.setVisibility(View.GONE);
                }


            }


        });
        P2OperationlGUNUNLOCke27CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if( P2OperationlGUNUNLOCke27CB.isChecked())
                {

                P2OperationlGUNLOCke26CB.setChecked(false);
                P2IndividualGUNLocke26CB.setChecked(false);
                P2IndividualGUNUNLocke27CB.setChecked(false);
                GunTurnOFFRadioButton();
                E26LockRG.clearCheck();
                E27UnLockRG.clearCheck();



                e27UnlockIV.setVisibility(View.VISIBLE);
            }
            else
            {
                e27UnlockIV.setVisibility(View.GONE);
            }

            }
        });
        P2IndividualGUNLocke26CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(P2IndividualGUNLocke26CB.isChecked()) {
                    E26LockRG.clearCheck();
                    P2OperationlGUNUNLOCke27CB.setChecked(false);
                    P2OperationlGUNLOCke26CB.setChecked(false);
                    P2IndividualGUNUNLocke27CB.setChecked(false);
                    GunUnLockE27Layout.setVisibility(View.GONE);
                    GunLockE26Layout.setVisibility(View.VISIBLE);
                    GunTurnOFFRadioButton();
                }
                else
                {
                    GunLockE26Layout.setVisibility(View.GONE);
                }

            }
        });
        P2IndividualGUNUNLocke27CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(P2IndividualGUNUNLocke27CB.isChecked()) {
                    E27UnLockRG.clearCheck();
                    P2OperationlGUNUNLOCke27CB.setChecked(false);
                    P2OperationlGUNLOCke26CB.setChecked(false);
                    P2IndividualGUNLocke26CB.setChecked(false);
                    GunLockE26Layout.setVisibility(View.GONE);
                    GunUnLockE27Layout.setVisibility(View.VISIBLE);
                    GunTurnOFFRadioButton();
                }
                else
                {
                    GunUnLockE27Layout.setVisibility(View.GONE);

                }
            }
        });


        P2manualHoistTestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "This is my Test btn!",
                        Toast.LENGTH_LONG).show();




            }
        });
        P2manualHoistDebugbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(P2OperationUpFastF3CB.isChecked()== true)
                {
                    MainTestModuleTabDivision.setVisibility(View.GONE);

                    P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upfastf3_dslr_debug_main));
                    P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3_high_dslr_schematic_mini));

                    p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                }
                else  if(P2OperationUpSlowF3CB.isChecked()==true)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                    // Setting Dialog Title
                    alertDialog.setTitle("Choose Output...");

                    // Setting Dialog Message
                    alertDialog.setMessage("Choose Debug Output to Proceed !!" );

                    // Setting Icon to Dialog


                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("F4 Low", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User pressed YES button. Write Logic Here
  // flagCurent board =0 means f4 Low
                                                     flagCurrentBoard=0;
                            MainTestModuleTabDivision.setVisibility(View.GONE);

                            P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upslowf4_dslr_debug_main));
                            P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4low_dslr_schematic_mini));

                            p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                        }
                    });

                    // Setting Negative "NO" Button
                    alertDialog.setNegativeButton("F3 High", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User pressed No button. Write Logic Here
                // // flagCurent board =1 means f3 high
                            flagCurrentBoard=1;
                            MainTestModuleTabDivision.setVisibility(View.GONE);

                            P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upfastf3_dslr_debug_main));
                            P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3_high_dslr_schematic_mini));

                            p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);



                        }
                    });

                    // Setting Netural "Cancel" Button
                    alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User pressed Cancel button. Write Logic Here

                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();

                }
              else if(P2OperationDownFastF4CB.isChecked()==true)
               {

                   MainTestModuleTabDivision.setVisibility(View.GONE);

                  P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downfastf4_dslr_debug_main));
                   P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4high_dslr_schematic_mini));

                   p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);

               }
               else if(P2OperationalDownSlowF4CB.isChecked()==true)
                {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                    // Setting Dialog Title
                    alertDialog.setTitle("Choose Output...");

                    // Setting Dialog Message
                    alertDialog.setMessage("Choose Debug Output to Proceed !!" );

                    // Setting Icon to Dialog


                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("F3 Low", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User pressed YES button. Write Logic Here
                            flagCurrentBoard=1;

                            MainTestModuleTabDivision.setVisibility(View.GONE);

                            P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downslowf3_dslr_debug_main));
                            P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3low_dslr_schematic_mini));

                            p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);

                        }
                    });

                    // Setting Negative "NO" Button
                    alertDialog.setNegativeButton("F4 High", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User pressed No button. Write Logic Here
                            flagCurrentBoard=0;

                            MainTestModuleTabDivision.setVisibility(View.GONE);

                            P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downfastf4_dslr_debug_main));
                            P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4high_dslr_schematic_mini));

                            p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                        }
                    });

                    // Setting Netural "Cancel" Button
                    alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User pressed Cancel button. Write Logic Here

                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();



                }
                else if(P2HoistIndividualF3HighCB.isChecked()==true && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==false)
                {

//F3 HIGH
                    if (((F3HighRG.getCheckedRadioButtonId() == -1)))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {

                        MainTestModuleTabDivision.setVisibility(View.GONE);
                        P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoistf3_high_dslr_schematic_main));

                        P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3_high_dslr_schematic_mini));

                        p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);
                    }
                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==true && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==false)
                {
// F3LOW
                    if (((F3LowRG.getCheckedRadioButtonId() == -1)))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        MainTestModuleTabDivision.setVisibility(View.GONE);

                        P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3_low_dslr_schematic_main));
                        P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3low_dslr_schematic_mini));

                        p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);
                    }
                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==true && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F4High
                    if (((F4HighRG.getCheckedRadioButtonId() == -1)))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {


                        MainTestModuleTabDivision.setVisibility(View.GONE);

                        P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upfastf3_dslr_debug_main));
                        P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4high_dslr_schematic_mini));

                        p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);
                    }
                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==true)
                {
//F4 LOW

                    if (((F4LowRG.getCheckedRadioButtonId() == -1)))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        MainTestModuleTabDivision.setVisibility(View.GONE);


                        P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4low_dslr_schematic_mini));

                        p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);
                    }
                }
                else if(P2HoistIndividualF3HighCB.isChecked()==true & P2HoistIndividualF3LowCB.isChecked()==false & P2HoistIndividualF4HighCB.isChecked()==false & P2HoistIndividualF4LowCB.isChecked()==true)
                {
//F3 HIgh,F4 Low

                   int selectedRadioGroupF3High = F3HighRG.getCheckedRadioButtonId();
                    int selectedRadioGroupF4Low = F4LowRG.getCheckedRadioButtonId();

                    if ((selectedRadioGroupF3High == -1 & selectedRadioGroupF4Low == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed!!",
                                Toast.LENGTH_SHORT).show();

                    }

                    else if ((selectedRadioGroupF3High != -1 & selectedRadioGroupF4Low == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed!!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if ((selectedRadioGroupF3High == -1 & selectedRadioGroupF4Low != -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed!!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (selectedRadioGroupF3High != -1 & selectedRadioGroupF4Low != -1)
                    {
                        selectedRadioButtonIDF3High = F3HighRG.getCheckedRadioButtonId();
                        selectedRadioButtonIDF4Low=F4LowRG.getCheckedRadioButtonId();

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                        // Setting Dialog Title
                        alertDialog.setTitle("Choose Output...");

                        // Setting Dialog Message
                        alertDialog.setMessage("Choose Debug Output to Proceed !!" );

                        // Setting Icon to Dialog


                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("F4 Low", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed YES button. Write Logic Here
                                // flagCurent board =0 means f4 Low
                                flagCurrentBoard=0;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upslowf4_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4low_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                            }
                        });

                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("F3 High", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed No button. Write Logic Here
                                // // flagCurent board =1 means f3 high
                                flagCurrentBoard=1;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upfastf3_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3_high_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);



                            }
                        });

                        // Setting Netural "Cancel" Button
                        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed Cancel button. Write Logic Here

                            }
                        });

                        // Showing Alert Message
                        alertDialog.show();
                    }









                }
                else if(P2HoistIndividualF3HighCB.isChecked()==true && P2HoistIndividualF3LowCB.isChecked()==false && P2HoistIndividualF4HighCB.isChecked()==true && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F4 HIgh,F3 High

                    int selectedRadioGroupF3High = F3HighRG.getCheckedRadioButtonId();
                    int selectedRadioGroupF4High = F4HighRG.getCheckedRadioButtonId();

                    if ((selectedRadioGroupF3High == -1 & selectedRadioGroupF4High == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();

                    }

                    else if ((selectedRadioGroupF3High != -1 & selectedRadioGroupF4High == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if ((selectedRadioGroupF3High == -1 & selectedRadioGroupF4High != -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (selectedRadioGroupF3High != -1 & selectedRadioGroupF4High != -1)
                    {
                        selectedRadioButtonIDF3High = F3HighRG.getCheckedRadioButtonId();
                        selectedRadioButtonIDF4Low=F4LowRG.getCheckedRadioButtonId();

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                        // Setting Dialog Title
                        alertDialog.setTitle("Choose Output...");

                        // Setting Dialog Message
                        alertDialog.setMessage("Choose Debug Output to Proceed !!" );

                        // Setting Icon to Dialog


                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("F4 High", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed YES button. Write Logic Here
                                // flagCurent board =0 means f4 Low
                                flagCurrentBoard=0;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downfastf4_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4high_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                            }
                        });

                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("F3 High", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed No button. Write Logic Here
                                // // flagCurent board =1 means f3 high
                                flagCurrentBoard=1;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upfastf3_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3_high_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);



                            }
                        });

                        // Setting Netural "Cancel" Button
                        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed Cancel button. Write Logic Here

                            }
                        });

                        // Showing Alert Message
                        alertDialog.show();
                    }






                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==true && P2HoistIndividualF4HighCB.isChecked()==false && P2HoistIndividualF4LowCB.isChecked()==true)
                {
//F3 Low,F4 Low

                    int selectedRadioGroupF3Low = F3LowRG.getCheckedRadioButtonId();
                    int selectedRadioGroupF4Low = F4LowRG.getCheckedRadioButtonId();

                    if ((selectedRadioGroupF3Low  == -1 & selectedRadioGroupF4Low == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();

                    }

                    else if ((selectedRadioGroupF3Low  != -1 & selectedRadioGroupF4Low == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed  !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if ((selectedRadioGroupF3Low  == -1 & selectedRadioGroupF4Low != -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed  !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (selectedRadioGroupF3Low  != -1 & selectedRadioGroupF4Low != -1)
                    {
                        selectedRadioButtonIDF3High = F3HighRG.getCheckedRadioButtonId();
                        selectedRadioButtonIDF4Low=F4LowRG.getCheckedRadioButtonId();

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                        // Setting Dialog Title
                        alertDialog.setTitle("Choose Output...");

                        // Setting Dialog Message
                        alertDialog.setMessage("Choose Debug Output to Proceed !!" );

                        // Setting Icon to Dialog


                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("F4 Low", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed YES button. Write Logic Here
                                // flagCurent board =0 means f4 Low
                                flagCurrentBoard=0;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_upslowf4_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4low_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                            }
                        });

                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("F3 Low", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed No button. Write Logic Here
                                // // flagCurent board =1 means f3 high
                                flagCurrentBoard=1;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downslowf3_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3low_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);



                            }
                        });

                        // Setting Netural "Cancel" Button
                        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed Cancel button. Write Logic Here

                            }
                        });

                        // Showing Alert Message
                        alertDialog.show();
                    }





                }
                else if(P2HoistIndividualF3HighCB.isChecked()==false && P2HoistIndividualF3LowCB.isChecked()==true && P2HoistIndividualF4HighCB.isChecked()==true && P2HoistIndividualF4LowCB.isChecked()==false)
                {
//F3 Low,F4 High
                    selectedRadioButtonIDF3Low = F3LowRG.getCheckedRadioButtonId();
                    selectedRadioButtonIDF4High=F4HighRG.getCheckedRadioButtonId();

                    if (( selectedRadioButtonIDF3Low  == -1 &  selectedRadioButtonIDF4High== -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();

                    }

                    else if (( selectedRadioButtonIDF3Low  != -1 &  selectedRadioButtonIDF4High == -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (( selectedRadioButtonIDF3Low  == -1 &  selectedRadioButtonIDF4High != -1))
                    {
                        Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if ( selectedRadioButtonIDF3Low  != -1 &  selectedRadioButtonIDF4High != -1) {
                        selectedRadioButtonIDF3High = F3HighRG.getCheckedRadioButtonId();
                        selectedRadioButtonIDF4Low = F4LowRG.getCheckedRadioButtonId();

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                        // Setting Dialog Title
                        alertDialog.setTitle("Choose Output...");

                        // Setting Dialog Message
                        alertDialog.setMessage("Choose Debug Output to Proceed !!");

                        // Setting Icon to Dialog


                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("F4 High", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed YES button. Write Logic Here
                                // flagCurent board =0 means f4 Low
                                flagCurrentBoard=0;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downfastf4_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f4high_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);



                            }
                        });

                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("F3 Low", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed No button. Write Logic Here
                                // // flagCurent board =1 means f3 high
                                flagCurrentBoard=1;
                                MainTestModuleTabDivision.setVisibility(View.GONE);

                                P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_downslowf3_dslr_debug_main));
                                P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_hoist_f3low_dslr_schematic_mini));

                                p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);

                            }
                        });

                        // Setting Netural "Cancel" Button
                        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User pressed Cancel button. Write Logic Here

                            }
                        });

                        // Showing Alert Message
                        alertDialog.show();

                    }
                    }


            }
        });
        P2manualGunDebugbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(P2OperationlGUNLOCke26CB.isChecked()==true)
                {




                    MainTestModuleTabDivision.setVisibility(View.GONE);

                    P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_lock_e26_dslr_debug_main));
                    P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_lock_e26_dslr_schematic_mini));

                    p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                }
                else  if(P2OperationlGUNUNLOCke27CB.isChecked()==true)
                {


                    MainTestModuleTabDivision.setVisibility(View.GONE);

                    P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_unlock_e27_dslr_debug_main));
                    P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_unlock_e27_dslr_schematic_mini));

                    p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);


                }
                else if(P2IndividualGUNUNLocke27CB.isChecked()==true)
                 {
                     if (E27UnLockRG.getCheckedRadioButtonId()  == -1)
                     {
                         Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                 Toast.LENGTH_SHORT).show();

                     }

                     else
                     {
                         // // flagCurent board =0 means e27unlock
                         flagCurrentBoard=0;
                         MainTestModuleTabDivision.setVisibility(View.GONE);

                         P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_unlock_e27_dslr_debug_main));
                         P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_unlock_e27_dslr_schematic_mini));

                         p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);

                     }

                 }
                else if(P2IndividualGUNLocke26CB.isChecked()==true)

                 {
                     if ( E26LockRG.getCheckedRadioButtonId()  == -1)
                     {
                         Toast.makeText(getActivity(), "Mark ON/OFF State to Proceed !!",
                                 Toast.LENGTH_SHORT).show();

                     }

                     else
                     {
                         // // flagCurent board =1 means e26lock
                         flagCurrentBoard=1;
                         MainTestModuleTabDivision.setVisibility(View.GONE);

                         P2manualMainDebugPicture.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_lock_e26_dslr_debug_main));
                         P2ThumbImageButtonSchematic.setBackground(getResources().getDrawable(R.drawable.p2_manual_gun_lock_e26_dslr_schematic_mini));
                         p2DSLRPICSLAYOUT.setVisibility(View.VISIBLE);

                     }




                 }

            }
        });
        P2manualHoistResetbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "This is my Reset btn!",
                    Toast.LENGTH_LONG).show();
        }
    });



BtnBackForP2board.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        p2DSLRPICSLAYOUT.setVisibility(View.GONE);
        MainTestModuleTabDivision.setVisibility(View.VISIBLE);

    }
});
        BtnProceedForP2Board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2DSLRPICSLAYOUT.setVisibility(View.GONE);
                MainTestModuleTabDivision.setVisibility(View.VISIBLE);

            }
        });












       manualRB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               automaticRB.setChecked(false);
               if (manualRB.isChecked())
               {
                   if (TestModuleSpinner.getSelectedItem().toString() == "P1 Board") {
//

                   }

                   else if (TestModuleSpinner.getSelectedItem().toString() == "P2 Board") {
//
                   }

                   else if (TestModuleSpinner.getSelectedItem().toString() == "P3 Board") {
//
                   }

                   else if (TestModuleSpinner.getSelectedItem().toString() == "P4 Board") {
//
                   }
                   else if (TestModuleSpinner.getSelectedItem().toString() == "P5 Board") {
//
                   }


               }
               else if (automaticRB.isChecked())
               {
                   if (TestModuleSpinner.getSelectedItem().toString() == "P1 Board") {
//
                   }
                   ////enter here
                   else if (TestModuleSpinner.getSelectedItem().toString() == "P2 Board") {
//
                   }
                   else if (TestModuleSpinner.getSelectedItem().toString() == "P3 Board")
                   {
//


                   } else if (TestModuleSpinner.getSelectedItem().toString() == "P4 Board") {
//
                   }
                   else if (TestModuleSpinner.getSelectedItem().toString() == "P5 Board")
                   {
//
                   }



               }

           }




});


        automaticRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manualRB.setChecked(false);

                if (manualRB.isChecked()) {
                    if (TestModuleSpinner.getSelectedItem().toString() == "P1 Board")
                    {

                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P2 Board")
                    {
//
                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P3 Board")
                    {
//
                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P4 Board")
                    {
//
                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P5 Board")
                    {
//
                    }


                }
                else if (automaticRB.isChecked())
                {
                    if (TestModuleSpinner.getSelectedItem().toString() == "P1 Board") {
//
                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P2 Board")
                    {
//
                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P3 Board")
                    {
//


                    } else if (TestModuleSpinner.getSelectedItem().toString() == "P4 Board") {
//
                    }
                    else if (TestModuleSpinner.getSelectedItem().toString() == "P5 Board")
                    {
//
//
                    }
                }



            }



        });

TestModuleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(TestModuleSpinner.getSelectedItem().toString() == "P1 Board")
        {
            automaticRB.setChecked(false);
            manualRB.setChecked(true);

//

        }
        else if (TestModuleSpinner.getSelectedItem().toString() == "P2 Board")
        {
            automaticRB.setChecked(false);
            manualRB.setChecked(true);

//


        }
        else if (TestModuleSpinner.getSelectedItem().toString() == "P3 Board")
        {
            automaticRB.setChecked(false);
            manualRB.setChecked(true);
//


        }
        else if (TestModuleSpinner.getSelectedItem().toString() == "P4 Board")
        {
            automaticRB.setChecked(false);
            manualRB.setChecked(true);

//










        }
        else if (TestModuleSpinner.getSelectedItem().toString() == "P5 Board")
        {
            automaticRB.setChecked(false);
            manualRB.setChecked(true);
//


        }







    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});
        return rootView;

    }


    private void spinner_fn(final String[] abc, final Spinner spn, ArrayAdapter ary) {
         ary = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.spinner_layout, abc);
        spn.setAdapter(ary);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spn.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    private void GunTurnOFFRadioButton() {
        GunLockE26RBOFF.setChecked(false);
        GunUnLockE27RBON.setChecked(false);
        GunUnLockE27RBOFF.setChecked(false);
        GunLockE26RBON.setChecked(false);
    }

    private  void HoistTurnOFFRadioButton()
    {

        F3HighRBON.setChecked(false);
        F3HighRBOFF.setChecked(false);
        F3LowRBON .setChecked(false);
        F3LowRBOFF.setChecked(false);
        F4HighRBON.setChecked(false);
        F4LowRBON.setChecked(false);
        F4LowRBOFF.setChecked(false);


    }

    private  void HoistTurnOFFOperationalLeds()
    {

        upfastf3IV.setVisibility(View.GONE);
        upslowf3IV.setVisibility(View.GONE);
        downfastf4IV.setVisibility(View.GONE);
        downslowf4IV.setVisibility(View.GONE);


    }


    private void HoistTurnOFFLayoutIndividual() {

        F3HighResultLayout.setVisibility(View.GONE);
        F3LowResultLayout.setVisibility(View.GONE);
        F4HighResultLayout.setVisibility(View.GONE);
        F4LowResultLayout.setVisibility(View.GONE);
    }

    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it immediately and proceed with this one.
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.

        expandedImageView.setImageResource(imageResId);


        // Calculate the starting and ending bounds for the zoomed-in image. This step
        // involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail, and the
        // final bounds are the global visible rectangle of the container view. Also
        // set the container view's offset as the origin for the bounds, since that's
        // the origin for the positioning animation properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        p2DSLRPICSLAYOUT.findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final bounds using the
        // "center crop" technique. This prevents undesirable stretching during the animation.
        // Also calculate the start scaling factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation begins,
        // it will position the zoomed-in view in the place of the thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations to the top-left corner of
        // the zoomed-in view (the default is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and scale properties
        // (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left,
                        finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top,
                        finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale, 1f))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down to the original bounds
        // and show the thumbnail instead of the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel, back to their
                // original values.
                AnimatorSet set = new AnimatorSet();
                set
                        .play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView, View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView, View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
            }
        });
    }

}
