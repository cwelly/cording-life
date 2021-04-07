using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ds : MonoBehaviour
{
    [SerializeField] public Text fire_inform;
    [SerializeField] public Image fire_panel;

    public float waittime = 5f;
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
            Fire.SetActive(false);

            fire_inform.enabled = false;
            fire_panel.enabled = false;



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
