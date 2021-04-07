using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class door_ctrl : MonoBehaviour
{
    public GameObject door_ct;
    Animator chaa;
    int i = 0;
    // Use this for initialization
    void Start()
    {

        chaa = door_ct.GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {

    }
    void OnTriggerStay(Collider col)
    {
        if (col.tag == "Play")
        {

            if (Input.GetKeyDown(KeyCode.E) || OVRInput.GetDown(OVRInput.Button.PrimaryIndexTrigger))
            {
                chaa.SetBool("open", true);

            }

        }
    }
}