using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class inform : MonoBehaviour {

    private bool enable_damage = false;
    [SerializeField] public Text imfo;
    [SerializeField] public Image hi_lighter;


    void Start()
    {

        imfo.enabled = false;
        hi_lighter.enabled = false;
    }
    void Update () {
        if (enable_damage) {

            imfo.enabled = true;
            hi_lighter.enabled = true;
        }
        else
        {

            imfo.enabled = false;
            hi_lighter.enabled = false;
        }
    }

    private void InforDamaging_Enable() {
        enable_damage = true;
    }

    private void InforDamaging_Disable()
    {
        enable_damage = false;
    }
}
