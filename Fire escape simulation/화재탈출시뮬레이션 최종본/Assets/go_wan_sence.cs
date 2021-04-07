using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;


public class go_wan_sence : MonoBehaviour {
    public GameObject cam1;
    public GameObject cam2;
    // Use this for initialization
    void Start () {
       // cam1 = GameObject.Find("OVRCameraRig");
       // cam2 = GameObject.Find("OVRCameraRig (2)");
        
    }
	
	// Update is called once per frame
	void Update () {
		
	}
    private void OnTriggerStay(Collider other)
    {
        if(other.tag=="Player")
        {
            if (Input.GetKeyDown(KeyCode.E) || OVRInput.GetDown(OVRInput.Button.PrimaryIndexTrigger))
            {
                cam1.SetActive(false);
                cam2.SetActive(true);
            }
        }
    }
}
