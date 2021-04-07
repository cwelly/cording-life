using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class firedamage : MonoBehaviour {

    public Image curhp;
    public Text infor_fire;
    public GameObject sound;

    public float damage = 15;

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player")
        {
            curhp.SendMessage("Setlastdam", "fire");
            curhp.SendMessage("TakeDamage", Time.deltaTime * damage);
            infor_fire.SendMessage("InforDamaging_Enable");
            sound.SendMessage("enableSound");
        }

    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player")
        {
            infor_fire.SendMessage("InforDamaging_Disable");
            sound.SendMessage("disableSound");
        }
    }

}
