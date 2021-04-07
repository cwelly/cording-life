using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class light : MonoBehaviour {
    public GameObject sig;
	// Use this for initialization
	void Start () {
    //    sig.transform.Find("OVRCameraRig");
	}
	
	// Update is called once per frame
	void Update () {
		
	}
    void OnTriggerEnter (Collider col)
    {
        if (col.tag == "Player")
        {
            sig.SetActive(false);
           

        }
    }
}
