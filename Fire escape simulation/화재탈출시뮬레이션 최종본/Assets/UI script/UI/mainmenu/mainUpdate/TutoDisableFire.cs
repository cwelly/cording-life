using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TutoDisableFire : MonoBehaviour
{
    [SerializeField] public Text fire_inform;
    [SerializeField] public Image fire_panel;
    public GameObject manager;
    public GameObject sound;
    public float waittime = 2f;
    private bool enablefire = true;
    public GameObject Fire;
    // Use this for initialization
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (!enablefire)
        {
            fire_inform.enabled = false;
            fire_panel.enabled = false;
            manager.SendMessage("CountDownFire");
            sound.SendMessage("enableSound");
            Fire.SetActive(false);




        }
    }
    private void DisableFire(float time)
    {
        waittime -= time;
        if (waittime < 0)
        {
            enablefire = false;
        }
    }
}
