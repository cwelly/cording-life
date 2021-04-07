using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class elecdamage : MonoBehaviour {

    public Image curhp;
    public Text infor_elec;
    public GameObject sound;

    public float dotDamage = 60;



    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "water")
        {
            sound.SendMessage("enableSound");
            curhp.SendMessage("Setlastdam", "elec");
            curhp.SendMessage("TakeDamage", Time.deltaTime * dotDamage);
            infor_elec.SendMessage("InforDamaging_Enable");
        }


    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "water")
        {
            sound.SendMessage("disableSound");
            infor_elec.SendMessage("InforDamaging_Disable");
        }
    }

}
