using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class pickUptwo : MonoBehaviour {
    [SerializeField] public Text inform1;
    [SerializeField] public Text inform2;
    [SerializeField] public Text extin1;
    [SerializeField] public Text extin2;
    [SerializeField] public Image ex_pan1;
    [SerializeField] public Image ex_pan2;
    [SerializeField] public Image im_in;
    [SerializeField] public Image im_lar;
    private int selection = 0;

    private bool selection_start = false;

    public GameObject in_space;

    public GameObject extinguisher1;
    public GameObject extinguisher2;
    public GameObject extinguisher1_dis;
    public GameObject extinguisher2_dis;

    // Use this for initialization
    void Start () {
        extinguisher1.SetActive(false);
        extinguisher2.SetActive(false);
        AllOff();


    }
	
	// Update is called once per frame
	void Update () {
        if (selection_start)
        {
            Debug.Log("선택창");
            im_in.enabled = false;
            im_lar.enabled = true;
            inform1.enabled = false;
            inform2.enabled = true;
            extin1.enabled = true;
            extin2.enabled = true;
            if (selection == 0)
            {
                ex_pan1.enabled = true;
                ex_pan2.enabled = false;
            }
            else if (selection == 1)
            {
                ex_pan1.enabled = false;
                ex_pan2.enabled = true;
            }

            if (OVRInput.GetUp(OVRInput.Button.PrimaryTouchpad) || Input.GetKeyUp(KeyCode.Z))
            {
                selection = (selection + 1) % 2;
            }
            if ((OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space)) && selection == 0)
            {
                Debug.Log("물");
                extinguisher1_dis.SetActive(false);
                extinguisher1.SetActive(true);


                Destroy(in_space);
                AllOff();
                selection_start = false;
            }
            else if ((OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space)) && selection == 1)
            {
                Debug.Log("분말");
                extinguisher2_dis.SetActive(false);
                extinguisher2.SetActive(true);


                Destroy(in_space);
                AllOff();
                selection_start = false;
            }
        }
    }

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player") {
            inform1.enabled = true;
            im_in.enabled = true;
            if (OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)) {
                selection_start = true;
            }
        }
    }

    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player") {
            AllOff();
        }
    }
    private void AllOff() {
        im_in.enabled = false;
        im_lar.enabled = false;
        selection_start = false;
        inform1.enabled = false;
        inform2.enabled = false;
        extin1.enabled = false;
        extin2.enabled = false;
        ex_pan1.enabled = false;
        ex_pan2.enabled = false;
    }
}
