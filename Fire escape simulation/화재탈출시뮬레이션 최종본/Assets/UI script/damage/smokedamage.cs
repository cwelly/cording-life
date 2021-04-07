using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class smokedamage : MonoBehaviour
{

    public float damage = 0.1f;
    public Text infor_smoke;
    private bool enable_dam = false;
    public Image curhp;
    public GameObject sound;
    void Update()
    {

        if (enable_dam)
        {

            curhp.SendMessage("Setlastdam", "smoke");
            curhp.SendMessage("TakeDamage", Time.deltaTime * damage);
        }

    }
    private void EnableDamaging() {
        enable_dam = true;
        sound.SendMessage("enableSound");
        infor_smoke.SendMessage("InforDamaging_Enable");
    }
    private void DisableDamaging()
    {
        enable_dam = false;
        sound.SendMessage("disableSound");
        infor_smoke.SendMessage("InforDamaging_Disable");
    }
}
