using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class HPmanage : MonoBehaviour {
    public GameObject sound;
    public Image HPBAR;
    private float HP = 100;
    private float MaxHP = 100;
    private string lastdam;
    private float s_x;
    private float s_y;

    private float s_z;


    void Start()
    {
        s_x = HPBAR.rectTransform.localScale.x;
        s_y = HPBAR.rectTransform.localScale.y;
        s_z = HPBAR.rectTransform.localScale.z;

    }

    private void Setlastdam(string lastdamage)
    {
        lastdam = lastdamage;
        Debug.Log(lastdamage);
    }

    private void UpdateHealthBar()
    {
        float ratio = HP / MaxHP;
        HPBAR.rectTransform.localScale = new Vector3(ratio*s_x, s_y, s_z);

    }
    private void TakeDamage(float damage)
    {
        HP -= damage;
        if (HP <= 0)
        {
            HP = 0;
            sound.SendMessage("disableSound");
            DeadEvent();
        }
        UpdateHealthBar();
    }
    private void DeadEvent()
    {
        if (lastdam == "fire")
        {
            SceneManager.LoadScene("Fire");
        }
        else if (lastdam == "elec")
        {
            SceneManager.LoadScene("Elec");
        }
        else if (lastdam == "smoke") {
            SceneManager.LoadScene("Smoke");
        }
    }
}
